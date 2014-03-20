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

public class ConnectAction extends Action {
	private FormBeanFactory<MakeWishForm> formBeanFactory = FormBeanFactory.getInstance(MakeWishForm.class);
	
	private ImageDAO iDAO;

	public ConnectAction(Model model) {
		iDAO = model.getImageDAO();
	}

	public String getName() { return "connect.do"; }
  
  public String perform(HttpServletRequest request) {
      
	        ArrayList<CommentCountBean> travelList = new ArrayList<CommentCountBean>();
	        ArrayList<CommentCountBean> relationList = new ArrayList<CommentCountBean>();
	        ArrayList<CommentCountBean> miscList = new ArrayList<CommentCountBean>();
	        
	        int premTravel = 0;
	        int premRelation = 0;
	        int premMisc = 0;
	        int quincyTravel = 0;
	        int quincyRelation = 0;
	        int quincyMisc = 0;
	        int garyTravel = 0;
	        int garyRelation = 0;
	        int garyMisc = 0;
	        
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
	        
	        for (int i = 0; i < travelList.size(); i++) {
	        	if (travelList.get(i).getUsername().equals("Gary_CCC"))
	        		garyTravel += travelList.get(i).getCount();
	        	else if (travelList.get(i).getUsername().equals("Quincygogo"))
	        		quincyTravel += travelList.get(i).getCount();
	        	else if (travelList.get(i).getUsername().equals("premsankar89"))
	        		premTravel += travelList.get(i).getCount();      	
	        }
	       
	        for (int i = 0; i < relationList.size(); i++) {
	        	if (relationList.get(i).getUsername().equals("Gary_CCC"))
	        		garyRelation += relationList.get(i).getCount();
	        	else if (relationList.get(i).getUsername().equals("Quincygogo"))
	        		quincyRelation += relationList.get(i).getCount();
	        	else if (relationList.get(i).getUsername().equals("premsankar89"))
	        		premRelation += relationList.get(i).getCount();      	
	        }
	       
	        for (int i = 0; i < miscList.size(); i++) {
	        	if (miscList.get(i).getUsername().equals("Gary_CCC"))
	        		garyMisc += miscList.get(i).getCount();
	        	else if (miscList.get(i).getUsername().equals("Quincygogo"))
	        		quincyMisc += miscList.get(i).getCount();
	        	else if (miscList.get(i).getUsername().equals("premsankar89"))
	        		premMisc += miscList.get(i).getCount();      	
	        }
	        
	       /* 
	        request.setAttribute("travelList", travelList);
	        request.setAttribute("relationList", relationList);
	        request.setAttribute("miscList", miscList);
	       */ 
	        System.out.println("Prem:"+premTravel+" "+premRelation+" "+premMisc);
	        request.setAttribute("premTravel", premTravel);
	        request.setAttribute("premRelation", premRelation);
	        request.setAttribute("premMisc", premMisc);
	        request.setAttribute("quincyTravel", quincyTravel);
	        request.setAttribute("quincyRelation", quincyRelation);
	        request.setAttribute("quincyMisc", quincyMisc);
	        request.setAttribute("garyTravel", garyTravel);
	        request.setAttribute("garyRelation", garyRelation);
	        request.setAttribute("garyMisc", garyMisc);
		    
	       /* System.out.println(premTravel + " " + premRelation + " " + premMisc + " " + quincyTravel + " " + 
	        			quincyRelation + " " +quincyMisc + " " + garyTravel + " " + garyRelation + " " + garyMisc);
	       */ 
	        request.setAttribute("travelCount", travelCount);
	        request.setAttribute("relationCount", relationCount);
	        request.setAttribute("miscCount", miscCount);
	        
	        return "cchart.jsp";
  }
}

