package com.newlecture.web.service.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

public class JDBCNoticeService implements NoticeService {
//	private String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
//	private String url = "jdbc:mysql://localhost:3306/newlec?serverTimezone=UTC";
//	private String uid = "root";
//	private String pwd = "jher235";
//	private String driver = "com.mysql.cj.jdbc.Driver";
//	private String driver = "oracle.jdbc.driver.OracleDriver";
	
	private DataSource datasource;


	
	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

	public List<Notice> getList(int page, String field, String query) throws ClassNotFoundException, SQLException{
		
//		int start = 1 + (page-1)*10;     // 1, 11, 21, 31, ..
//		int end = 10*page; // 10, 20, 30, 40...
//		
//		String sql = "SELECT * FROM NOTICE_VIEW WHERE "+field+" LIKE ? AND NUM BETWEEN ? AND ?";	
//		
//		Class.forName(driver);
//		Connection con = DriverManager.getConnection(url,uid, pwd);
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setString(1, "%"+query+"%");
//		st.setInt(2, start);
//		st.setInt(3, end);
//		ResultSet rs = st.executeQuery();
//		
//		List<Notice> list = new ArrayList<Notice>();
		
		int limit = 10;
	    int offset = (page - 1) * limit; // MySQL에서 페이지 시작 인덱스 계산
	    
	    String sql = "SELECT * FROM NOTICE WHERE " + field + " LIKE ? LIMIT ? OFFSET ?"; 
	    
//	    Class.forName(driver);
//	    try (Connection con = DriverManager.getConnection(url, uid, pwd);
	    try (Connection con = datasource.getConnection();
	         PreparedStatement st = con.prepareStatement(sql)) {
	        
	        st.setString(1, "%" + query + "%");
	        st.setInt(2, limit);
	        st.setInt(3, offset);
	        
	        try (ResultSet rs = st.executeQuery()) {
	            List<Notice> list = new ArrayList<>();
		
		
		
		while(rs.next()){
		    int id = rs.getInt("ID");
		    String title = rs.getString("TITLE");
		    String writerId = rs.getString("WRITER_ID");
		    Date regDate = rs.getDate("REGDATE");
		    String content = rs.getString("CONTENT");
		    int hit = rs.getInt("hit");
		    String files = rs.getString("FILES");
		    
		    Notice notice = new Notice(
		    					id,
		    					title,
		    					writerId,
		    					regDate,
		    					content,
		    					hit,
		    					files
		    				);

		    list.add(notice);
		    
		}
		 return list;
	        }
	    }
	}
		
//		rs.close();
//		st.close();
//		con.close();
//		
//		return list;
//	}
	
	// Scalar 
	public int getCount() throws ClassNotFoundException, SQLException {
		int count = 0;
		
		String sql = "SELECT COUNT(ID) COUNT FROM NOTICE";	
		
//		Class.forName(driver);
//		Connection con = DriverManager.getConnection(url,uid, pwd);
		Connection con = datasource.getConnection();
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next())
			count = rs.getInt("COUNT");		
		
		rs.close();
		st.close();
		con.close();
		
		return count;
	}
	
	// 수정된 insert 메서드
	public int insert(Notice notice) throws SQLException, ClassNotFoundException {
	    String title = notice.getTitle();
	    String writerId = notice.getWriterId();
	    String content = notice.getContent();
	    String files = notice.getFiles();
	    
	    String sql = "INSERT INTO notice (title, writer_id, content, files) VALUES (?, ?, ?, ?)";  
	    
//	    Class.forName(driver);
//	    try (Connection con = DriverManager.getConnection(url, uid, pwd);
	    try (Connection con = datasource.getConnection();
	         PreparedStatement st = con.prepareStatement(sql)) {
	        
	        st.setString(1, title);
	        st.setString(2, writerId);
	        st.setString(3, content);
	        st.setString(4, files);
	        
	        return st.executeUpdate();
	    }
	}

	// 수정된 update 메서드
	public int update(Notice notice) throws SQLException, ClassNotFoundException {
	    String title = notice.getTitle();
	    String content = notice.getContent();
	    String files = notice.getFiles();
	    int id = notice.getId();
	    
	    String sql = "UPDATE NOTICE SET TITLE=?, CONTENT=?, FILES=? WHERE ID=?";
	    
//	    Class.forName(driver);
//	    try (Connection con = DriverManager.getConnection(url, uid, pwd);
	    try (Connection con = datasource.getConnection();
	         PreparedStatement st = con.prepareStatement(sql)) {
	        
	        st.setString(1, title);
	        st.setString(2, content);
	        st.setString(3, files);
	        st.setInt(4, id);
	        
	        return st.executeUpdate();
	    }
	}

	// 수정된 delete 메서드
	public int delete(int id) throws ClassNotFoundException, SQLException {
	    String sql = "DELETE FROM NOTICE WHERE ID=?";
	    
//	    Class.forName(driver);
//	    try (Connection con = DriverManager.getConnection(url, uid, pwd);
	    try (Connection con = datasource.getConnection();
	         PreparedStatement st = con.prepareStatement(sql)) {
	        
	        st.setInt(1, id);
	        
	        return st.executeUpdate();
	    }
	}


//	public int insert(Notice notice) throws SQLException, ClassNotFoundException {
//		String title = notice.getTitle();
//		String writerId = notice.getWriterId();
//		String content = notice.getContent();
//		String files = notice.getFiles();
//		
//		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
//		String sql = "INSERT INTO notice (    " + 
//				"    title," + 
//				"    writer_id," + 
//				"    content," + 
//				"    files" + 
//				") VALUES (?,?,?,?)";	
//		
//		Class.forName(driver);
//		Connection con = DriverManager.getConnection(url,uid, pwd);                   
//		//Statement st = con.createStatement();
//		//st.ex....(sql)
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setString(1, title);
//		st.setString(2, writerId);
//		st.setString(3, content);
//		st.setString(4, files);
//		
//		int result = st.executeUpdate();
//		
//		
//		st.close();
//		con.close();
//		
//		return result;
//	}
//	
//	public int update(Notice notice) throws SQLException, ClassNotFoundException {
//		String title = notice.getTitle();
//		String content = notice.getContent();
//		String files = notice.getFiles();
//		int id = notice.getId();
//		
//		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
//		String sql = "UPDATE NOTICE " + 
//				"SET" + 
//				"    TITLE=?," + 
//				"    CONTENT=?," + 
//				"    FILES=?" + 
//				"WHERE ID=?";
//		
//		Class.forName(driver);
//		Connection con = DriverManager.getConnection(url,uid, pwd);                   
//		//Statement st = con.createStatement();
//		//st.ex....(sql)
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setString(1, title);
//		st.setString(2, content);
//		st.setString(3, files);
//		st.setInt(4, id);
//		
//		int result = st.executeUpdate();
//				
//		st.close();
//		con.close();
//		
//		return result;
//	}
//	
//	public int delete(int id) throws ClassNotFoundException, SQLException {
//	
//		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
//		String sql = "DELETE NOTICE WHERE ID=?";
//		
//		Class.forName(driver);
//		Connection con = DriverManager.getConnection(url,uid, pwd);                  
//		//Statement st = con.createStatement();
//		//st.ex....(sql)
//		PreparedStatement st = con.prepareStatement(sql);		
//		st.setInt(1, id);
//		
//		int result = st.executeUpdate();
//				
//		st.close();
//		con.close();
//		
//		return result;
//	}

	
}
