//lily
package model;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;


public class Model {
	private Chart1DAO  c1DAO;
	private CommentDAO commentDAO;
	private ImageDAO imageDAO;
	private UserDAO userDAO;
	private HistoryDAO hisDAO;
	public Model(ServletConfig config) throws ServletException, MyDAOException, DAOException {
		try {
			String jdbcDriver = config.getInitParameter("jdbcDriverName");
			String jdbcURL    = config.getInitParameter("jdbcURL");
			
			ConnectionPool pool = new ConnectionPool(jdbcDriver, jdbcURL);
			c1DAO  = new Chart1DAO(jdbcDriver, jdbcURL, "makewish", "tag","category");
			commentDAO= new CommentDAO( pool,"comment");
			imageDAO=new ImageDAO(jdbcDriver, jdbcURL,"image","comment");
			hisDAO=new HistoryDAO(jdbcDriver, jdbcURL,"history");
			userDAO=new UserDAO(pool, "user");
		}
		catch (MyDAOException e) {
			throw new ServletException(e);
		}
	}
	public Chart1DAO getChart1DAO() { return c1DAO; }
	public CommentDAO getCommentDAO() {return commentDAO;}
    public HistoryDAO getHistoryDAO(){return hisDAO;}
	public ImageDAO getImageDAO() {return imageDAO;}
	public UserDAO getUserDAO() {return userDAO;}
}
