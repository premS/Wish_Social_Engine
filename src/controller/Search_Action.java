package controller;

import javax.servlet.http.HttpServletRequest;

import model.Chart1DAO;
import model.Model;
import model.MyDAOException;

public class Search_Action extends Action {
	private Chart1DAO cdao;
	public Search_Action(Model model) {
		// TODO Auto-generated constructor stub
	cdao=model.getChart1DAO();
	}
	public String getName() { return "search.do"; }
	 public String perform(HttpServletRequest request) {
		 try {
			request.setAttribute("wish_name",cdao.getwishnames());
		} catch (MyDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			return "search.jsp";
	 }
}
