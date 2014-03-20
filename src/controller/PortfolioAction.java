package controller;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import databeans.history;
import databeans.wish_success;
import model.Chart1DAO;
import model.HistoryDAO;
import model.ImageDAO;
import model.Model;
import model.MyDAOException;

public class PortfolioAction extends Action{
	
	private HistoryDAO hisDAO;
	private ImageDAO imgDAO;
	
	public PortfolioAction(Model model) {
		
		hisDAO = model.getHistoryDAO();
		imgDAO = model.getImageDAO();
	}

	public String getName() {
		return "portfolio.do";
	}
	public String perform(HttpServletRequest request) {
		try {
			String userName = (String) request.getSession().getAttribute("screen_name");
			ArrayList<history> h1= hisDAO.gethistory(userName);
			request.setAttribute("his", h1);
			ArrayList<wish_success> w1= imgDAO.getsuccess(userName);
			request.setAttribute("wish", w1);
		} catch (MyDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return "portfolio.jsp";
	}
}
