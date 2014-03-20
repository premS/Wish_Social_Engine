package controller;

import javax.servlet.http.HttpServletRequest;

import model.Chart1DAO;
import model.Model;
import model.MyDAOException;

public class search_wish1 extends Action {
	
	public search_wish1(Model model) {
		// TODO Auto-generated constructor stub
	}
	public String getName() { return "search_wish1.do"; }
	 public String perform(HttpServletRequest request) {
		 System.out.print(request.getParameter("img_id"));
		request.getSession().setAttribute("img_id",  request.getParameter("img_id"));
			return "makewish_start1.do";
	 }
	 }

