package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.MyWishBean;
import formbeans.FulfillWishForm;
import model.Chart1DAO;
import model.Model;
import model.MyDAOException;

public class updateFailedWish extends Action{

	private Chart1DAO cDAO;
	private FormBeanFactory<FulfillWishForm> FulfillWishFormFactory = FormBeanFactory.getInstance(FulfillWishForm.class);
	
	public updateFailedWish(Model model) {
		cDAO = model.getChart1DAO();
	}
	@Override
	public String getName() {
		return "updateFailedWish.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		
		
		 List<String> errors = new ArrayList<String>();
		    request.setAttribute("errors",errors);
		    int mwid = Integer.parseInt(request.getParameter("id"));
		    FulfillWishForm form = null;
			try {
				form = FulfillWishFormFactory.create(request);
				
			} catch (FormBeanException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			MyWishBean wish = new MyWishBean() ;
			String[] tagName = null;

			wish.setMwid(mwid);
       		wish.setResultdesc(form.getResultdesc());
       		wish.setEndDate(form.getFinishdate());
       		//System.out.println(form.getFinishdate());
       		
   			cDAO.updateFailedWish(wish);
			try {
				
				request.setAttribute("form", form);
				tagName = cDAO.getFailedTagName();
				wish = cDAO.getFulfillWish(mwid);
			
			
			} catch (MyDAOException e) {
				errors.add(e.getMessage());
	        	System.out.println("Exception");
	        	return "error.jsp";
			}

		
			if(wish.getState().equals("undone")) {
				request.setAttribute("wish",wish);
				request.setAttribute("tagName",tagName);
				
				return "fulfillwish.jsp";
			}
			else {
				
				return "success.jsp";
			}
		
	
	}

}
