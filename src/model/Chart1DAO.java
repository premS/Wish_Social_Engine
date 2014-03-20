//lily
package model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import databeans.MyWishBean;

public class Chart1DAO {

	private List<Connection> connectionPool = new ArrayList<Connection>();

	private String jdbcDriver;
	private String jdbcURL;
	private String tableName1;
	private String tableName2;
	private String tableName3;
	
	public Chart1DAO(String jdbcDriver, String jdbcURL, String tableName1, String tableName2, String tableName3) throws MyDAOException {
		this.jdbcDriver = jdbcDriver;
		this.jdbcURL    = jdbcURL;
		this.tableName1  = tableName1;
		this.tableName2  = tableName2;
		this.tableName3  = tableName3;
		
		if (!tableExists()) createTable();
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
	
	public void updateSucceededWish(MyWishBean wish) {
		Connection con = null;
        try {
        	con = getConnection();
        	con.setAutoCommit(false);
  
         	PreparedStatement pstmt = con.prepareStatement("UPDATE " + tableName1 + " SET resultdesc=?, endDate=?, state = ?, tag1id=?,tag2id=?,tag3id=? WHERE mwid=?");
        	pstmt.setString(1,wish.getResultdesc());
        	pstmt.setString(2, wish.getEndDate());
        	pstmt.setString(3,"succeeded");
        	pstmt.setInt(4,1);
        	pstmt.setInt(5,2);
        	pstmt.setInt(6,3);
        	pstmt.setInt(7,wish.getMwid());
        	pstmt.executeUpdate();

        
        	con.commit();
        	pstmt.close();
        	releaseConnection(con);
        } catch (Exception e) {
            try { if (con != null){con.rollback(); con.close();} } catch (SQLException e2) { /* ignore */ }
        	try {
				throw new MyDAOException(e);
			} catch (MyDAOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
     
	}
	
	public void updateFailedWish(MyWishBean wish) {
		Connection con = null;
        try {
        	con = getConnection();
        	con.setAutoCommit(false);
  
         	PreparedStatement pstmt = con.prepareStatement("UPDATE " + tableName1 + " SET resultdesc=?, endDate=?, state = ?, tag1id=?,tag2id=?,tag3id=? WHERE mwid=?");
        	pstmt.setString(1,wish.getResultdesc());
        	pstmt.setString(2, wish.getEndDate());
        	pstmt.setString(3,"failed");
        	pstmt.setInt(4,8);
        	pstmt.setInt(5,9);
        	pstmt.setInt(6,10);
        	pstmt.setInt(7,wish.getMwid());
        	pstmt.executeUpdate();

        
        	con.commit();
        	pstmt.close();
        	releaseConnection(con);
        } catch (Exception e) {
            try { if (con != null){con.rollback(); con.close();} } catch (SQLException e2) { /* ignore */ }
        	try {
				throw new MyDAOException(e);
			} catch (MyDAOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
     
	}
	
	
	public MyWishBean getFulfillWish(int mwid) throws MyDAOException {
		MyWishBean wish = new MyWishBean();
		
		Connection con = null;
        try {
        	con = getConnection();
        	con.setAutoCommit(false);
        	PreparedStatement pstmt = con.prepareStatement("SELECT * FROM " + tableName1 + " WHERE mwid = ?"); 
         	pstmt.setInt(1,mwid);
        	ResultSet rs = pstmt.executeQuery();
      
        	while(rs.next()){
        		wish.setMwid(rs.getInt("mwid"));
        		wish.setCategory(rs.getString("category"));
        		wish.setStartdate(rs.getString("startdate"));
        		wish.setState(rs.getString("state"));
        		wish.setResultdesc(rs.getString("resultdesc"));
        		wish.setEndDate(rs.getString("endDate"));
        		String wishdesc = rs.getString("wishdesc");
        		wishdesc = wishdesc.replaceAll("_", " ");
        		wish.setWishdesc(wishdesc);
        		wish.setImgid(rs.getString("imgid"));
        		wish.setTag1(rs.getInt("tag1id"));
        		wish.setTag2(rs.getInt("tag2id"));
        		wish.setTag2(rs.getInt("tag3id"));
        	}

        	rs.close();
        	con.commit();
        	pstmt.close();
        	releaseConnection(con);
        } catch (Exception e) {
            try { if (con != null){con.rollback(); con.close();} } catch (SQLException e2) { /* ignore */ }
        	throw new MyDAOException(e);
        }
		return wish;
		
	}
	public String[] getFailedTagName() throws MyDAOException {
    	String[] tagName = new String[5];
    	Connection con = null;
        try {
        	con = getConnection();
        	con.setAutoCommit(false);
        	PreparedStatement pstmt = con.prepareStatement("SELECT * FROM " + tableName2 + " WHERE tagid > 5 and tagid<11");    
        	ResultSet rs = pstmt.executeQuery();
        	int i = 0;
        	while(rs.next()){
        		tagName[i] = rs.getString("tagdesc");
        		i++;
        	}

        	rs.close();
        	con.commit();
        	pstmt.close();
        	releaseConnection(con);
        } catch (Exception e) {
            try { if (con != null){con.rollback(); con.close();} } catch (SQLException e2) { /* ignore */ }
        	throw new MyDAOException(e);
        }
        return tagName;
	}
	public String[] getSuccessTagName() throws MyDAOException {
    	String[] tagName = new String[5];
    	Connection con = null;
        try {
        	con = getConnection();
        	con.setAutoCommit(false);
        	PreparedStatement pstmt = con.prepareStatement("SELECT * FROM " + tableName2 + " WHERE tagid < 6");    
        	ResultSet rs = pstmt.executeQuery();
        	int i = 0;
        	while(rs.next()){
        		tagName[i] = rs.getString("tagdesc");
        		i++;
        	}

        	rs.close();
        	con.commit();
        	pstmt.close();
        	releaseConnection(con);
        } catch (Exception e) {
            try { if (con != null){con.rollback(); con.close();} } catch (SQLException e2) { /* ignore */ }
        	throw new MyDAOException(e);
        }
        return tagName;
	}
	
    public int getSuccessWishNum(String userName) throws MyDAOException {
    	
    	Connection con = null;
		int s = 0;
        try {
        	con = getConnection();
        	con.setAutoCommit(false);
        	PreparedStatement pstmt = con.prepareStatement("SELECT count(*) FROM " + tableName1 + " WHERE state=? AND username=?");
        	pstmt.setString(1,"succeeded");
        	pstmt.setString(2,userName);
        	ResultSet rs = pstmt.executeQuery();
        	
        	while(rs.next()){
        		s = rs.getInt("count(*)");
        	}

        	rs.close();
        	con.commit();
        	pstmt.close();
        	releaseConnection(con);
        } catch (Exception e) {
            try { if (con != null){con.rollback(); con.close();} } catch (SQLException e2) { /* ignore */ }
        	throw new MyDAOException(e);
        }
        return s;
    	
    }
    
    public int getFailedWishNum(String userName) throws MyDAOException {
    	
    	Connection con = null;
		int s = 0;
        try {
        	con = getConnection();
        	con.setAutoCommit(false);
        	PreparedStatement pstmt = con.prepareStatement("SELECT count(*) FROM " + tableName1 + " WHERE state=? AND username=?");
        	pstmt.setString(1,"failed");
        	pstmt.setString(2,userName);
        	ResultSet rs = pstmt.executeQuery();
        	
        	while(rs.next()){
        		s = rs.getInt("count(*)");
        	}

        	rs.close();
        	con.commit();
        	pstmt.close();
        	releaseConnection(con);
        } catch (Exception e) {
            try { if (con != null){con.rollback(); con.close();} } catch (SQLException e2) { /* ignore */ }
        	throw new MyDAOException(e);
        }
        return s;
    	
    }
    
    public int getUndoneWishNum(String userName) throws MyDAOException {
    	
    	Connection con = null;
		int s = 0;
        try {
        	con = getConnection();
        	con.setAutoCommit(false);
        	PreparedStatement pstmt = con.prepareStatement("SELECT count(*) FROM " + tableName1 + " WHERE state=? AND username=?");
        	pstmt.setString(1,"undone");
        	pstmt.setString(2,userName);
        	ResultSet rs = pstmt.executeQuery();
        	
        	while(rs.next()){
        		s = rs.getInt("count(*)");
        	}

        	rs.close();
        	con.commit();
        	pstmt.close();
        	releaseConnection(con);
        } catch (Exception e) {
            try { if (con != null){con.rollback(); con.close();} } catch (SQLException e2) { /* ignore */ }
        	throw new MyDAOException(e);
        }
        return s;
    	
    }
	public ArrayList<MyWishBean> getMyWishes(String userName) throws MyDAOException {
		ArrayList<MyWishBean>  myWishes = new ArrayList<MyWishBean> ();
		Connection con = null;
        try {
        	con = getConnection();
            con.setAutoCommit(false);
        	PreparedStatement pstmt = con.prepareStatement("SELECT * FROM " + tableName1 +" WHERE username=?");
        	pstmt.setString(1,userName);
        	ResultSet rs = pstmt.executeQuery();
      
        	while (rs.next()) {   
        		MyWishBean wish = new MyWishBean();
        		wish = new MyWishBean();
        		wish.setMwid(rs.getInt("mwid"));
        		wish.setCategory(rs.getString("category"));
        		wish.setStartdate(rs.getString("startdate"));
        		wish.setState(rs.getString("state"));
        		wish.setResultdesc(rs.getString("resultdesc"));
        		wish.setEndDate(rs.getString("endDate"));
        		String wishdesc = rs.getString("wishdesc");
        		wishdesc = wishdesc.replaceAll("_", " ");
        		wish.setWishdesc(wishdesc);
        		wish.setImgid(rs.getString("imgid"));
        		wish.setTag1(rs.getInt("tag1id"));
        		wish.setTag2(rs.getInt("tag2id"));
        		wish.setTag2(rs.getInt("tag3id"));
        		myWishes.add(wish);
        	//id=rs.getInt("categoryid");
        	}
        	System.out.println(myWishes.size());
        	rs.close();
        	con.commit();
        	pstmt.close();
        	releaseConnection(con);
        	return myWishes;
            
        } catch (Exception e) {
            try { if (con != null){ con.rollback();con.close(); }} catch (SQLException e2) { /* ignore */ }
        	throw new MyDAOException(e);
        }
		
		
	}
	public int getCategoryId(String cname) throws MyDAOException {
		Connection con = null;
        try {
        	con = getConnection();
            con.setAutoCommit(false);
        	PreparedStatement pstmt = con.prepareStatement("SELECT categoryid FROM " + tableName3 +" WHERE title=?");
        	pstmt.setString(1,cname);
        	ResultSet rs = pstmt.executeQuery();
        	int id=0;
        	while (rs.next()) {        	 
        	id=rs.getInt("categoryid");
        	}
        	rs.close();
        	con.commit();
        	pstmt.close();
        	releaseConnection(con);
            return id;
            
        } catch (Exception e) {
            try { if (con != null){ con.rollback();con.close(); }} catch (SQLException e2) { /* ignore */ }
        	throw new MyDAOException(e);
        }
	}
	
	public String getwishnames() throws MyDAOException {
		Connection con = null;
        try {
        	con = getConnection();
            con.setAutoCommit(false);
        	PreparedStatement pstmt = con.prepareStatement("SELECT wishdesc FROM " + tableName1 );
        	ResultSet rs = pstmt.executeQuery();
        	
        	StringBuilder sb=new StringBuilder();
        	while (rs.next()) {        	 
        		sb.append("'"+rs.getString("wishdesc")+"',");
        	}
        	sb.substring(0, sb.length()-1);
        	rs.close();
        	con.commit();
        	pstmt.close();
        	releaseConnection(con);
            return sb.toString();
            
        } catch (Exception e) {
            try { if (con != null){ con.rollback();con.close(); }} catch (SQLException e2) { /* ignore */ }
        	throw new MyDAOException(e);
        }
	}
	public String getimageid(String wish) throws MyDAOException {
		Connection con = null;
        try {
        	System.out.println("Wish is"+wish);
        	con = getConnection();
            con.setAutoCommit(false);
        	PreparedStatement pstmt = con.prepareStatement("SELECT imgid FROM " + tableName1 +" WHERE wishdesc=?");
        	pstmt.setString(1,wish);
        	ResultSet rs = pstmt.executeQuery();
        	String id=null;
        	while (rs.next()) {        	 
        	id=rs.getString("imgid");
        	System.out.println("ImgId"+id);
        	}
        	rs.close();
        	con.commit();
        	pstmt.close();
        	releaseConnection(con);
            return id;
            
        } catch (Exception e) {
            try { if (con != null){ con.rollback();con.close(); }} catch (SQLException e2) { /* ignore */ }
        	throw new MyDAOException(e);
        }
	}
	public String getcatwish(String id) throws MyDAOException {
		Connection con = null;
        try {
        	con = getConnection();
            con.setAutoCommit(false);
            
        	PreparedStatement pstmt = con.prepareStatement("SELECT wishdesc,category FROM " + tableName1 +" WHERE imgid=?");
        	pstmt.setString(1,id);
        	ResultSet rs = pstmt.executeQuery();
        	String result="";
        	while (rs.next()) {        	 
        	result=rs.getString("wishdesc")+";";
        	result+=rs.getString("category");
        	}
        	rs.close();
        	con.commit();
        	pstmt.close();
        	releaseConnection(con);
            return result;
            
        } catch (Exception e) {
            try { if (con != null){ con.rollback();con.close(); }} catch (SQLException e2) { /* ignore */ }
        	throw new MyDAOException(e);
        }
	}
	private boolean tableExists() throws MyDAOException {
		Connection con = null;
        try {
        	con = getConnection();
        	DatabaseMetaData metaData = con.getMetaData();
        	ResultSet rs = metaData.getTables(null, null, tableName1, null);
        	
        	boolean answer = rs.next();
        	
        	rs.close();
        	releaseConnection(con);
        	
        	return answer;

        } catch (SQLException e) {
            try { if (con != null) con.close(); } catch (SQLException e2) { /* ignore */ }
        	throw new MyDAOException(e);
        }
    }

	private void createTable() throws MyDAOException {
		Connection con = null;
        try {
        	con = getConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("create table "+tableName1+" (userid int not null," +
            		"username, hashedpassword,salt,twitterId,flickrId,gender,age," +
            		" primary key(userid))");
            stmt.close();
        	
        	releaseConnection(con);

        } catch (SQLException e) {
            try { if (con != null) con.close(); } catch (SQLException e2) { /* ignore */ }
        	throw new MyDAOException(e);
        }
    }
	
	public int getWishResultS(int wishId) throws MyDAOException {
		Connection con = null;
		int s = 0;
        try {
        	con = getConnection();
        	con.setAutoCommit(false);
        	PreparedStatement pstmt = con.prepareStatement("SELECT count(*) FROM " + tableName1 + " WHERE state=? AND category=?");
        	pstmt.setString(1,"succeeded");
        	pstmt.setInt(2,wishId);
        	ResultSet rs = pstmt.executeQuery();
        	
        	while(rs.next()){
        		s = rs.getInt("count(*)");
        	}

        	rs.close();
        	con.commit();
        	pstmt.close();
        	releaseConnection(con);
        } catch (Exception e) {
            try { if (con != null){con.rollback(); con.close();} } catch (SQLException e2) { /* ignore */ }
        	throw new MyDAOException(e);
        }
        return s;
	}
	
	public int getWishResultF(int wishId) throws MyDAOException {
		Connection con = null;
		int s = 0;
        try {
        	con = getConnection();
        	con.setAutoCommit(false);
        	PreparedStatement pstmt = con.prepareStatement("SELECT count(*) FROM " + tableName1 + " WHERE state=? AND category=?");
        	pstmt.setString(1,"failed");
        	pstmt.setInt(2,wishId);
        	ResultSet rs = pstmt.executeQuery();
        	
        	while(rs.next()){
        		s = rs.getInt("count(*)");
        	}

        	rs.close();
        	con.commit();
        	pstmt.close();
        	releaseConnection(con);
        } catch (Exception e) {
            try { if (con != null){con.rollback(); con.close();} } catch (SQLException e2) { /* ignore */ }
        	throw new MyDAOException(e);
        }
        return s;
	}
	
	public int getWishResultU(int wishId) throws MyDAOException {
		Connection con = null;
		int s = 0;
        try {
        	con = getConnection();
        	con.setAutoCommit(false);
        	PreparedStatement pstmt = con.prepareStatement("SELECT count(*) FROM " + tableName1 + " WHERE state=? AND category=?");
        	pstmt.setString(1,"undone");
        	pstmt.setInt(2,wishId);
        	ResultSet rs = pstmt.executeQuery();
        	
        	while(rs.next()){
        		s = rs.getInt("count(*)");
        	}

        	rs.close();
        	con.commit();
        	pstmt.close();
        	releaseConnection(con);
        } catch (Exception e) {
            try { if (con != null){con.rollback(); con.close();} } catch (SQLException e2) { /* ignore */ }
        	throw new MyDAOException(e);
        }
        return s;
	}
	
	public int[] getSuccessReason(int wishId) throws MyDAOException {
		Connection con = null;
		int[] tags = new int[5];
		int tag = 0;
		try {
        	con = getConnection();
        	con.setAutoCommit(false);
        	PreparedStatement pstmt = con.prepareStatement("SELECT tag1id,tag2id,tag3id FROM " + tableName1 + " WHERE state=? AND category=?");
        	pstmt.setString(1,"succeeded");
        	pstmt.setInt(2,wishId);
        	ResultSet rs = pstmt.executeQuery();
        	
        	while(rs.next()){
        		tag = rs.getInt("tag1id");
        		addTag(tag,tags);
        		tag = rs.getInt("tag2id");
        		addTag(tag,tags);
        		tag = rs.getInt("tag3id");
        		addTag(tag,tags);
        	}

        	rs.close();
        	con.commit();
        	pstmt.close();
        	releaseConnection(con);
        } catch (Exception e) {
            try { if (con != null){con.rollback(); con.close();} } catch (SQLException e2) { /* ignore */ }
        	throw new MyDAOException(e);
        }
		return tags;
	}
	
	public int[] getFailReason(int wishId) throws MyDAOException {
		Connection con = null;
		int[] tags = new int[5];
		int tag = 0;
		try {
        	con = getConnection();
        	con.setAutoCommit(false);
        	PreparedStatement pstmt = con.prepareStatement("SELECT tag1id,tag2id,tag3id FROM " + tableName1 + " WHERE state=? AND category=?");
        	pstmt.setString(1,"failed");
        	pstmt.setInt(2,wishId);
        	ResultSet rs = pstmt.executeQuery();
        	
        	while(rs.next()){
        		tag = rs.getInt("tag1id");
        		addTag(tag,tags);
        		tag = rs.getInt("tag2id");
        		addTag(tag,tags);
        		tag = rs.getInt("tag3id");
        		addTag(tag,tags);
        	}

        	rs.close();
        	con.commit();
        	pstmt.close();
        	releaseConnection(con);
        } catch (Exception e) {
            try { if (con != null){con.rollback(); con.close();} } catch (SQLException e2) { /* ignore */ }
        	throw new MyDAOException(e);
        }
		return tags;
	}
	
	public void addTag(int tag, int[] tags) {
		if (tag%5==1) tags[0]++;
		else if (tag%5==2) tags[1]++;
		else if (tag%5==3) tags[2]++;
		else if (tag%5==4) tags[3]++;
		else if (tag%5==0) tags[4]++;
	}
	
	public void insert_wish(String cat,String uid,String start_date,String state,String wishdesc,String imgid) throws MyDAOException {
		Connection con = null;
		String temp=null;
        try {
        	con = getConnection();
        	con.setAutoCommit(false);
        	PreparedStatement pstmt = con.prepareStatement("INSERT INTO " + tableName1 + " (category,username,startdate,state,wishdesc,imgid) VALUES (?,?,?,?,?,?)");
        	pstmt.setString(1,cat);
        	pstmt.setString(2,uid);
        	pstmt.setString(3,start_date);
        	pstmt.setString(4,state);
        	pstmt.setString(5,wishdesc);
        	pstmt.setString(6,imgid);
        	int count = pstmt.executeUpdate();
        	if (count != 1) throw new SQLException("Insert updated "+count+" rows");
        	con.commit();
        	pstmt.close();
        	releaseConnection(con);
        } catch (Exception e) {
            try { if (con != null){ con.rollback();con.close();} } catch (SQLException e2) { /* ignore */ }
        	throw new MyDAOException(e);
        }
	}
	public String getTagName(int tagId) throws MyDAOException {
		Connection con = null;
		String s = "";
        try {
        	con = getConnection();
        	con.setAutoCommit(false);
        	PreparedStatement pstmt = con.prepareStatement("SELECT tagdesc FROM " + tableName2 + " WHERE tagid=?");
        	pstmt.setInt(1,tagId);
        	ResultSet rs = pstmt.executeQuery();
        	
        	while(rs.next()){
        		s = rs.getString("tagdesc");
        	}

        	rs.close();
        	con.commit();
        	pstmt.close();
        	releaseConnection(con);
        } catch (Exception e) {
            try { if (con != null){con.rollback(); con.close();} } catch (SQLException e2) { /* ignore */ }
        	throw new MyDAOException(e);
        }
        return s;
	}
}
