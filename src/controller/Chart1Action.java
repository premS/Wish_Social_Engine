//lily
package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Model;
import model.Chart1DAO;

import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.WishResultBean;
import formbeans.MakeWishForm;

public class Chart1Action extends Action {
	private FormBeanFactory<MakeWishForm> formBeanFactory = FormBeanFactory.getInstance(MakeWishForm.class);
	
	private Chart1DAO cDAO;

	public Chart1Action(Model model) {
		cDAO = model.getChart1DAO();
	}

	public String getName() { return "chart1.do"; }
    
    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
        try {
        	MakeWishForm form = formBeanFactory.create(request);

        	errors.addAll(form.getValidationErrors());
	        if (errors.size() != 0) {
	            return "error.jsp";
	        }
	        
	        String wish = form.getWishNameShort();
	        int wishId = 0;
	        int[] sReasons = new int[5];
	        int[] fReasons = new int[5];
	        
	        if (wish.equals("travel")) wishId=1;
	        if (wish.equals("bfgf")) wishId=2;
	        if (wish.equals("health")) wishId=3;
	        if (wish.equals("family")) wishId=4;
	        if (wish.equals("a")) wishId=5;
	        
	        WishResultBean wishResult = new WishResultBean();
	        wishResult.setS(cDAO.getWishResultS(wishId));
	        wishResult.setF(cDAO.getWishResultF(wishId));
	        wishResult.setU(cDAO.getWishResultU(wishId));
	        
	        sReasons = cDAO.getSuccessReason(wishId);
	        fReasons = cDAO.getFailReason(wishId);
	        
	        wishResult.setT1(sReasons[0]);
	        wishResult.setT2(sReasons[1]);
	        wishResult.setT3(sReasons[2]);
	        wishResult.setT4(sReasons[3]);
	        wishResult.setT5(sReasons[4]);
	        wishResult.setT6(fReasons[0]);
	        wishResult.setT7(fReasons[1]);
	        wishResult.setT8(fReasons[2]);
	        wishResult.setT9(fReasons[3]);
	        wishResult.setT10(fReasons[4]);
	        
	        wishResult.setTS1(cDAO.getTagName((wishId-1)*10+1));
	        wishResult.setTS2(cDAO.getTagName((wishId-1)*10+2));
	        wishResult.setTS3(cDAO.getTagName((wishId-1)*10+3));
	        wishResult.setTS4(cDAO.getTagName((wishId-1)*10+4));
	        wishResult.setTS5(cDAO.getTagName((wishId-1)*10+5));
	        wishResult.setTS6(cDAO.getTagName((wishId-1)*10+6));
	        wishResult.setTS7(cDAO.getTagName((wishId-1)*10+7));
	        wishResult.setTS8(cDAO.getTagName((wishId-1)*10+8));
	        wishResult.setTS9(cDAO.getTagName((wishId-1)*10+9));
	        wishResult.setTS10(cDAO.getTagName((wishId-1)*10+10));
	        
	        HttpSession session = request.getSession();
	        session.setAttribute("wishResult",wishResult);
           
	        return "chart1.jsp";
        }catch (FormBeanException e) {
        	errors.add(e.getMessage());
        	System.out.println("FormBeanException");
        	return "error.jsp";
        } 
        catch (Exception e) {
        	errors.add(e.getMessage());
        	System.out.println("Exception");
        	return "error.jsp";
        } 
    }
}
