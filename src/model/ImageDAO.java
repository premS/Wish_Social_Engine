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
import databeans.wish_comment;
import databeans.wish_success;

public class ImageDAO {

	private List<Connection> connectionPool = new ArrayList<Connection>();

	private String jdbcDriver;
	private String jdbcURL;
	private String tableName1;
	private String tableName2;
	public ImageDAO(String jdbcDriver, String jdbcURL, String tableName1,String t2) throws MyDAOException {
		this.jdbcDriver = jdbcDriver;
		this.jdbcURL    = jdbcURL;
		this.tableName1  = tableName1;
		this.tableName2  = t2;
		
		
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
	public ArrayList<CommentBean> getComment(int imgId) throws MyDAOException {
		Connection con = null;
		int s = 0;
		ArrayList<CommentBean> cb1=new ArrayList<CommentBean>();
        try {
        	con = getConnection();
        	con.setAutoCommit(false);
        	PreparedStatement pstmt = con.prepareStatement("SELECT comment,date,userName FROM " + tableName2 + " WHERE photoid=? order by commentId asc ");
        	pstmt.setInt(1,imgId);
        	ResultSet rs = pstmt.executeQuery();
        	
        	while(rs.next()){
        		CommentBean cb=new CommentBean();
        		cb.setComment(rs.getString("comment"));
        		cb.setDate(rs.getString("date"));
        		cb.setUserName(rs.getString("username"));
        		cb1.add(cb);
        	}

        	rs.close();
        	con.commit();
        	pstmt.close();
        	releaseConnection(con);
        } catch (Exception e) {
            try { if (con != null){con.rollback(); con.close();} } catch (SQLException e2) { /* ignore */ }
        	throw new MyDAOException(e);
        }
        return cb1;
	}	
	
	
	public ArrayList<wish_success> getsuccess(String uname) throws MyDAOException {
		Connection con = null;
		int s = 0;
		ArrayList<wish_success> cb1=new ArrayList<wish_success>();
        try {
        	con = getConnection();
        	con.setAutoCommit(false);
        	String sq="SELECT COUNT(*) as count,category,username,state FROM wishapp.makewish where username=? and state ='succeeded' group by category, state";
        	
        	PreparedStatement pstmt = con.prepareStatement(sq);
        	pstmt.setString(1, uname);
        	ResultSet rs = pstmt.executeQuery();
        	
        	while(rs.next()){
        	   wish_success cb=new wish_success();
        		cb.setUname(rs.getString("username"));
        		cb.setCategory(rs.getString("category"));
        		cb.setCount(rs.getInt("count"));
        		cb1.add(cb);
        	}
        	rs.close();
        	con.commit();
        	pstmt.close();
        	releaseConnection(con);
        } catch (Exception e) {
            try { if (con != null){con.rollback(); con.close();} } catch (SQLException e2) { /* ignore */ }
        	throw new MyDAOException(e);
        }
        return cb1;
	}
	
	public ArrayList<wish_comment> getcwish() throws MyDAOException {
		Connection con = null;
		int s = 0;
		ArrayList<wish_comment> cb1=new ArrayList<wish_comment>();
        try {
        	con = getConnection();
        	con.setAutoCommit(false);
        	String sq="SELECT wishdesc,photoId, count(*) as count FROM wishapp.comment join wishapp.makewish on photoId = imgid GROUP BY photoId ORDER BY count(*) DESC LIMIT 3";
        	PreparedStatement pstmt = con.prepareStatement(sq);
        	ResultSet rs = pstmt.executeQuery();
        	
        	while(rs.next()){
        	   wish_comment cb=new wish_comment();
        		cb.setWish(rs.getString("wishdesc"));
        		cb.setPid(rs.getInt("photoId"));
        		cb.setCount(rs.getInt("count"));
        		cb1.add(cb);
        	}
        	rs.close();
        	con.commit();
        	pstmt.close();
        	releaseConnection(con);
        } catch (Exception e) {
            try { if (con != null){con.rollback(); con.close();} } catch (SQLException e2) { /* ignore */ }
        	throw new MyDAOException(e);
        }
        return cb1;
	}
	
	public int ccount() throws MyDAOException {
		Connection con = null;
		int count = 0;
        try {
        	con = getConnection();
        	con.setAutoCommit(false);
        	String sq="select count(*) as count from wishapp.comment;";
        	PreparedStatement pstmt = con.prepareStatement(sq);
        	ResultSet rs = pstmt.executeQuery();
        	
        	while(rs.next()){
        		count=rs.getInt("count");
        	}
        	rs.close();
        	con.commit();
        	pstmt.close();
        	releaseConnection(con);
        } catch (Exception e) {
            try { if (con != null){con.rollback(); con.close();} } catch (SQLException e2) { /* ignore */ }
        	throw new MyDAOException(e);
        }
        return count;
	}
	public String getURL(int imgId) throws MyDAOException {
		Connection con = null;
		int s = 0;
		String url="";
        try {
        	con = getConnection();
        	con.setAutoCommit(false);
        	PreparedStatement pstmt = con.prepareStatement("SELECT pid,secret,farm,server FROM " + tableName1 + " WHERE idimage=? ");
        	pstmt.setInt(1,imgId);
        	ResultSet rs = pstmt.executeQuery();
        	
        	while(rs.next()){
        		url="http://farm"+rs.getString("farm")+".staticflickr.com/"+rs.getString("server")+"//"+rs.getString("pid")+"_"+rs.getString("secret")+"_z.jpg";
        			
        	}

        	rs.close();
        	con.commit();
        	pstmt.close();
        	releaseConnection(con);
        } catch (Exception e) {
            try { if (con != null){con.rollback(); con.close();} } catch (SQLException e2) { /* ignore */ }
        	throw new MyDAOException(e);
        }
        return url;
	}
	public int insert_image(String pid,String owner,String secret,String farm,String server) throws MyDAOException {
		Connection con = null;
		String temp=null;int key=0;
        try {
        	con = getConnection();
        	con.setAutoCommit(false);
        	PreparedStatement pstmt = con.prepareStatement("INSERT INTO " + tableName1 + " (pid,owner,secret,farm,server) VALUES (?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
        	
        	pstmt.setString(1,pid);
        	pstmt.setString(2,owner);
        	pstmt.setString(3,secret);
        	pstmt.setString(4,farm);
        	pstmt.setString(5,server);
        	int count = pstmt.executeUpdate();
        	ResultSet keys = pstmt.getGeneratedKeys();    
        	keys.next();  
            key = keys.getInt(1);
        	keys.close();
        	System.out.println("count ai:"+key);
        	if (count != 1) throw new SQLException("Insert updated "+count+" rows");
        	//SELECT LAST_INSERT_ID()
        	con.commit();
        	pstmt.close();
        	releaseConnection(con);
        } catch (Exception e) {
            try { if (con != null){ con.rollback();con.close();} } catch (SQLException e2) { /* ignore */ }
        	throw new MyDAOException(e);
        }
        return key;
	}

	
	//Gary
	
	public ArrayList<CommentCountBean> getCommentCount(String category) throws MyDAOException {
		Connection con = null;
		int s = 0;
		ArrayList<CommentCountBean> ccList=new ArrayList<CommentCountBean>();
        try {
        	con = getConnection();
        	con.setAutoCommit(false);
        	String sq="SELECT wishapp.comment.username,category, count(*) as count FROM wishapp.comment join wishapp.makewish on photoId = imgid where category=? GROUP BY username ORDER BY count(*) DESC LIMIT 3";
        	
        	PreparedStatement pstmt = con.prepareStatement(sq);
        	pstmt.setString(1,category);
        	ResultSet rs = pstmt.executeQuery();
        	
        	while(rs.next()){
        		CommentCountBean cc=new CommentCountBean();
        		cc.setUsername(rs.getString("username"));
        		cc.setCategory(rs.getString("category"));
        		cc.setCount(rs.getInt("count"));
        		ccList.add(cc);
        	}
        	rs.close();
        	con.commit();
        	pstmt.close();
        	releaseConnection(con);
        } catch (Exception e) {
            try { if (con != null){con.rollback(); con.close();} } catch (SQLException e2) { /* ignore */ }
        	throw new MyDAOException(e);
        }
        return ccList;
	}
	
	
	
	
	
}
