package controller;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import databeans.CommentBean;
import databeans.WishResultBean;
import model.Chart1DAO;
import model.ImageDAO;
import model.Model;
import model.MyDAOException;

public class MakeWish_Start1 extends Action {
	private ImageDAO imageDAO;
	private Chart1DAO cDAO;
public MakeWish_Start1(Model model) {
		
	imageDAO = model.getImageDAO();
	cDAO = model.getChart1DAO();
	}

	public String getName() {
		return "makewish_start1.do";
	}
	public String perform(HttpServletRequest request) {
		String img_id=(String) request.getSession().getAttribute("img_id");
		ArrayList<CommentBean> cb=new ArrayList<CommentBean>();
		try {
			String url=imageDAO.getURL(Integer.parseInt(img_id));
			 cb=imageDAO.getComment(Integer.parseInt(img_id));
		    request.setAttribute("url", url);
		    request.setAttribute("img_id",img_id);
		    request.setAttribute("cb", cb);
		    request.setAttribute("csize", cb.size());
		    String result=cDAO.getcatwish(img_id);
		    String r1[]=result.split(";");
		    request.setAttribute("wcat", r1[1]);
		    request.setAttribute("wishd", r1[0]);
		    
		    int cid = cDAO.getCategoryId(r1[1]);
		    WishResultBean wishResult = new WishResultBean();
		    int[] sReasons = new int[5];
	        int[] fReasons = new int[5];
	        
		    wishResult.setS(cDAO.getWishResultS(cid));
	        wishResult.setF(cDAO.getWishResultF(cid));
	        wishResult.setU(cDAO.getWishResultU(cid));
	        
	        sReasons = cDAO.getSuccessReason(cid);
	        fReasons = cDAO.getFailReason(cid);
	        
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
	        
	        wishResult.setTS1(cDAO.getTagName((cid-1)*10+1));
	        wishResult.setTS2(cDAO.getTagName((cid-1)*10+2));
	        wishResult.setTS3(cDAO.getTagName((cid-1)*10+3));
	        wishResult.setTS4(cDAO.getTagName((cid-1)*10+4));
	        wishResult.setTS5(cDAO.getTagName((cid-1)*10+5));
	        wishResult.setTS6(cDAO.getTagName((cid-1)*10+6));
	        wishResult.setTS7(cDAO.getTagName((cid-1)*10+7));
	        wishResult.setTS8(cDAO.getTagName((cid-1)*10+8));
	        wishResult.setTS9(cDAO.getTagName((cid-1)*10+9));
	        wishResult.setTS10(cDAO.getTagName((cid-1)*10+10));
	        
	        HttpSession session = request.getSession();
	        session.setAttribute("wishResult",wishResult);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MyDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Voila"+cb.size());
		return "your_wish.jsp";
	}
}
