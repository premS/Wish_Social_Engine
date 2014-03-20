package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import databeans.CommentBean;
import databeans.CommentCountBean;
import databeans.history;
import databeans.wish_comment;

public class HistoryDAO {

	private List<Connection> connectionPool = new ArrayList<Connection>();

	private String jdbcDriver;
	private String jdbcURL;
	private String tableName1;
	private String tableName2;
	public HistoryDAO(String jdbcDriver, String jdbcURL, String tableName1) throws MyDAOException {
		this.jdbcDriver = jdbcDriver;
		this.jdbcURL    = jdbcURL;
		this.tableName1  = tableName1;
		
		
		
	}
	private synchronized Connection getConnection() throws MyDAOException {
		if (connectionPool.size() > 0) {
			return connectionPool.remove(connectionPool.size()-1);
		}
		
        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException e) {
            throw new MyDAOException(e);
        }

        try {
            return DriverManager.getConnection(jdbcURL);
        } catch (SQLException e) {
            throw new MyDAOException(e);
        }
	}
	
	private synchronized void releaseConnection(Connection con) {
		connectionPool.add(con);
	}
	public ArrayList<history> gethistory(String uname) throws MyDAOException {
		Connection con = null;
		int s = 0;
		ArrayList<history> h1=new ArrayList<history>();
        try {
        	con = getConnection();
        	con.setAutoCommit(false);
        	PreparedStatement pstmt = con.prepareStatement("SELECT * FROM " + tableName1+" WHERE username=?");
pstmt.setString(1, uname);
        	ResultSet rs = pstmt.executeQuery();
        	
        	while(rs.next()){
        		history hi=new history();
        		hi.setUserName(rs.getString("username"));
        		hi.setYear(rs.getString("year"));
        		hi.setSuccess(rs.getString("success"));
        		hi.setFailure(rs.getString("failure"));
        		h1.add(hi);
        	}

        	rs.close();
        	con.commit();
        	pstmt.close();
        	releaseConnection(con);
        } catch (Exception e) {
            try { if (con != null){con.rollback(); con.close();} } catch (SQLException e2) { /* ignore */ }
        	throw new MyDAOException(e);
        }
        return h1;
	}	
}