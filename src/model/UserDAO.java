package model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;






import databeans.UserBean;

public class UserDAO extends GenericDAO<UserBean>{

	public UserDAO(ConnectionPool cp, String tableName) throws DAOException {
		super(UserBean.class, tableName, cp);
		// TODO Auto-generated constructor stub
	}
	
	
		
	
}
