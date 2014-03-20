package controller;

import javax.servlet.http.HttpServletRequest;

import model.Chart1DAO;
import model.Model;
import model.MyDAOException;

public class search_wish extends Action {
	private Chart1DAO cdao;
	public search_wish(Model model) {
		// TODO Auto-generated constructor stub
		cdao=model.getChart1DAO();
	}
	public String getName() { return "search_wish.do"; }
	 public String perform(HttpServletRequest request) {
		String tag= request.getParameter("url");
		String imgid=null;
		try {
			imgid=cdao.getimageid(wish_name);
		} catch (MyDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		request.getSession().setAttribute("img_id", imgid);
			return "makewish_start1.do";
	 }
	 }

