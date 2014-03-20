//Sophia
package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import databeans.MyWishBean;
import model.Chart1DAO;
import model.Model;
import model.MyDAOException;

public class ViewMyWishAction extends Action {
	private Chart1DAO cDAO;


	public ViewMyWishAction(Model model) {
		cDAO = model.getChart1DAO();
	}

	@Override
	public String getName() {		
		return "mywish.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
	    List<String> errors = new ArrayList<String>();
	    request.setAttribute("errors",errors);
		
		
		String userName = new String();
		ArrayList<MyWishBean> myWishes = new ArrayList<MyWishBean>() ;
		userName = (String) request.getSession().getAttribute("screen_name");
		int successWishNum  = 0;
		int failedWishNum = 0;
		int undoneWishNum = 0;
		try {
			myWishes = cDAO.getMyWishes(userName);
			System.out.println("call me:"+myWishes.size());
			successWishNum = cDAO.getSuccessWishNum(userName);
			failedWishNum = cDAO.getFailedWishNum(userName);
			undoneWishNum = cDAO.getUndoneWishNum(userName);
			
		} catch (MyDAOException e) {
			errors.add(e.getMessage());
        	System.out.println("Exception");
        	return "error.jsp";
		}


		request.setAttribute("myWishes",myWishes);
		request.setAttribute("successWishNum", successWishNum);
		request.setAttribute("failedWishNum", failedWishNum);
		request.setAttribute("undoneWishNum", undoneWishNum);
		System.out.println(successWishNum+" " +failedWishNum+" "+ undoneWishNum);
		return "mywish.jsp";
	}

}
