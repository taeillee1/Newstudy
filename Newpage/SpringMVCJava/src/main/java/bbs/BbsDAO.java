package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BbsDAO {
	private Connection conn;
	private ResultSet rs;
	
	public BbsDAO() {
		try {
			String dbURL="jdbc:mysql://localhost:3306/BBS";
			String dbID = "root";
			String dbPassword = "root";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(dbURL,dbID,dbPassword);
		}catch(Exception e) {
			e.printStackTrace();		
		}
	}
	
	public String getDate() {
		String SQL = "SELECT NOW()"; //현재의 시간을 가져오는 SQL문법
		try {
			PreparedStatement pstmt=conn.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	public int getNext() {
		String SQL = "SELECT bbsID FROM BBS ORDER BY bbsID DESC"; 
		try {
			PreparedStatement pstmt=conn.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1)+1;
			}
			return 1; // 첫번째 게시물인 경우
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //데이터 베이스 오류
	}
	
	public int write(String bbsTitle, String userID ,String bbsContent) {
		String SQL = "INSERT INTO BBS VALUES(?, ?, ?, ?, ?, ?)"; 
		try {
			PreparedStatement pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, bbsTitle);
			pstmt.setString(3, userID);
			pstmt.setString(4, getDate());
			pstmt.setString(5, bbsContent);
			pstmt.setInt(6, 1);
			return pstmt.executeUpdate();//올바르게 인서트 되었을시 0이상의 값을 반환하고
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //아니면ㄴ -1을 반환하는 것 
	}
	
	public ArrayList<Bbs> getList(int pageNumber){
		String SQL = "SELECT * FROM BBS WHERE bbsID < ? AND bbsAvailable = 1 ORDER BY bbsID DESC LIMIT 10";
		ArrayList<Bbs> list = new ArrayList<Bbs>();
		try {
			PreparedStatement pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext()-(pageNumber-1)*10);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Bbs bbs = new Bbs();
				bbs.setBbsID(rs.getInt(1));
				bbs.setBbsTitle(rs.getString(2));
				bbs.setUserID(rs.getString(3));
				bbs.setBbsDate(rs.getString(4));
				bbs.setBbsContent(rs.getString(5));
				bbs.setBbsAvailable(rs.getInt(6));
				list.add(bbs);
			}
			 //  
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean nextPage(int pageNumber) {//게시글이 10개라면 다음페이지라는 것이 존재하면 안되고 10개 넘어가면 다음페이지가 존재해야하기 때문에 쓰는 함수
		String SQL = "SELECT * FROM BBS WHERE bbsID < ? AND bbsAvailable = 1 ORDER BY bbsID DESC LIMIT 10";
		try {
			PreparedStatement pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext()-(pageNumber-1)*10);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			 //  
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false; 
	}
	

	public Bbs getBbs(int bbsID) {
		String SQL = "SELECT *FROM BBS WHERE bbsID = ?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, bbsID);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Bbs bbs = new Bbs();
				bbs.setBbsID(rs.getInt(1));
				bbs.setBbsTitle(rs.getString(2));
				bbs.setUserID(rs.getString(3));
				bbs.setBbsDate(rs.getString(4));
				bbs.setBbsContent(rs.getString(5));
				bbs.setBbsAvailable(rs.getInt(6));
				return bbs;
			}
			 //  
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int update(int bbsID, String bbsTitle, String bbsContent) {
		String SQL = "UPDATE BBS SET bbsTitle = ?, bbsContent = ? WHERE bbsID = ?"; 
		try {
			PreparedStatement pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, bbsTitle);
			pstmt.setString(2, bbsContent);
			pstmt.setInt(3, bbsID);
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //아니면ㄴ -1을 반환하는 것 
	}
	
	public int delete(int bbsID) {
		String SQL = "UPDATE BBS SET bbsAvailable = 0 WHERE bbsID = ?"; // 글을 삭제하더라도 글의 정보가 남아있게 하기위해서 bbsAvailable의 값을 건드린다
		try {
			PreparedStatement pstmt=conn.prepareStatement(SQL);
			pstmt.setInt(1, bbsID);
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //아니면ㄴ -1을 반환하는 것 
	}
	
	public ArrayList<Bbs> getSearch(int pageNumber, String searchField, String searchText){
	      ArrayList<Bbs> list = new ArrayList<Bbs>();
	      String SQL ="select * from bbs WHERE bbsID < ? AND bbsAvailable = 1 AND "+searchField;
	      try {
	            if(searchText != null && !searchText.equals("")){
	                SQL +=" LIKE '%"+searchText+"%' order by bbsID DESC LIMIT 10";
	            }
	            PreparedStatement pstmt=conn.prepareStatement(SQL);
	            pstmt.setInt(1, getNext()-(pageNumber-1)*10);
				rs=pstmt.executeQuery();
	         while(rs.next()) {
	            Bbs bbs = new Bbs();
	            bbs.setBbsID(rs.getInt(1));
	            bbs.setBbsTitle(rs.getString(2));
	            bbs.setUserID(rs.getString(3));
	            bbs.setBbsDate(rs.getString(4));
	            bbs.setBbsContent(rs.getString(5));
	            bbs.setBbsAvailable(rs.getInt(6));
	            list.add(bbs);//list에 해당 인스턴스를 담는다.
	         }         
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	      return list;//ㄱㅔ시글 리스트 반환
	   }
	public int getCount(String searchField, String searchText) {
		String SQL = "select count(*) from bbs WHERE "+searchField;
	      try {
	            if(searchText != null && !searchText.equals("") ){
	                SQL +=" LIKE '%"+searchText.trim()+"%' order by bbsID desc LIMIT 10";
	            }
	            PreparedStatement pstmt=conn.prepareStatement(SQL);
	            
				rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int getCount() {
		String SQL = "select count(*) from bbs";
		try {
			PreparedStatement pstmt=conn.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
}