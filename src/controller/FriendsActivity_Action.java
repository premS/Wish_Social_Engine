package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Model;
import model.ImageDAO;
import model.MyDAOException;

import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.CommentCountBean;
import databeans.WishResultBean;
import databeans.wish_comment;
import formbeans.MakeWishForm;

public class FriendsActivity_Action extends Action {
	private FormBeanFactory<MakeWishForm> formBeanFactory = FormBeanFactory.getInstance(MakeWishForm.class);
	
	private ImageDAO iDAO;

	public FriendsActivity_Action(Model model) {
		iDAO = model.getImageDAO();
	}

	public String getName() { return "trending.do"; }
  
  public String perform(HttpServletRequest request) {
      
	        ArrayList<CommentCountBean> travelList = new ArrayList<CommentCountBean>();
	        ArrayList<CommentCountBean> relationList = new ArrayList<CommentCountBean>();
	        ArrayList<CommentCountBean> miscList = new ArrayList<CommentCountBean>();
	        int travelCount = 0;
	        int relationCount = 0;
	        int miscCount = 0;
	        
	        try {
	        	String cate = "Travel";
	        	travelList = iDAO.getCommentCount(cate);
				for(CommentCountBean bean:travelList){
					travelCount += bean.getCount();
				}
			} catch (MyDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        try {
	        	String cate = "Relationship";
	        	relationList = iDAO.getCommentCount(cate);
				for(CommentCountBean bean:relationList){
					relationCount += bean.getCount();
				}
			} catch (MyDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
	        	String cate = "Misc";
	        	miscList = iDAO.getCommentCount(cate);
				for(CommentCountBean bean:miscList){
					miscCount += bean.getCount();
				}
			} catch (MyDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        request.setAttribute("travelList", travelList);
	        request.setAttribute("relationList", relationList);
	        request.setAttribute("miscList", miscList);
	        
	        request.setAttribute("travelCount", travelCount);
	        request.setAttribute("relationCount", relationCount);
	        request.setAttribute("miscCount", miscCount);
	        
	        return "connect.jsp";
  }
}

