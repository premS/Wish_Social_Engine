package controller;

//lily


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Model;
import model.ImageDAO;
import model.MyDAOException;

import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.WishResultBean;
import databeans.wish_comment;
import formbeans.MakeWishForm;

public class Trending_Action extends Action {
	private FormBeanFactory<MakeWishForm> formBeanFactory = FormBeanFactory.getInstance(MakeWishForm.class);
	
	private ImageDAO iDAO;

	public Trending_Action(Model model) {
		iDAO = model.getImageDAO();
	}

	public String getName() { return "trending.do"; }
  
  public String perform(HttpServletRequest request) {
      
	        ArrayList<wish_comment> cw=new ArrayList<wish_comment>();
	        int comment_count=0,trending_count=0;
	        try {
				cw=iDAO.getcwish();
				comment_count=iDAO.ccount();
				for(wish_comment wc:cw){
					trending_count+=wc.getCount();
				}
				System.out.println(comment_count+" : "+trending_count);
			} catch (MyDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        request.setAttribute("wc", cw);
	        
	        request.setAttribute("diff", comment_count-trending_count);
	        return "trending.jsp";
  }
}

