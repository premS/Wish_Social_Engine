package model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;




import databeans.CommentBean;

public class CommentDAO extends GenericDAO<CommentBean>{

	public CommentDAO(ConnectionPool cp, String tableName) throws DAOException {
		super(CommentBean.class, tableName, cp);
		// TODO Auto-generated constructor stub
	}
	
	
		
	
}
