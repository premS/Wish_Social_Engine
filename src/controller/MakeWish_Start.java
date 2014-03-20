package controller;

import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import model.Chart1DAO;
import model.ImageDAO;
import model.Model;
import model.MyDAOException;

public class MakeWish_Start extends Action{
	
	private ImageDAO imageDAO;
	private Chart1DAO chartDAO;
	public MakeWish_Start(Model model) {
		
		imageDAO = model.getImageDAO();
		chartDAO = model.getChart1DAO();
	}

	public String getName() {
		return "makewish_start.do";
	}
	public String perform(HttpServletRequest request) {
		String val=request.getParameter("hid");
		String wish=request.getParameter("wish");
	    String cat=request.getParameter("h_cat");
		int imgid=0;
		String pid=null,server=null,owner=null,secret=null,farm=null;
		String x[]=val.split(";");
		server=x[0];
	    farm=x[1];
	    pid=x[2];
	    owner=x[3];
	    secret=x[4];
	    try {
	    	String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			imgid=imageDAO.insert_image(pid,owner,secret,farm,server);
    		String username=(String) request.getSession().getAttribute("screen_name");
    		System.out.println(cat + username+ date+wish+imgid);
			chartDAO.insert_wish(cat,username,date,"undone",wish,""+imgid+"");
		} catch (MyDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String url="http://farm"+farm+".staticflickr.com/"+server+"//"+pid+"_"+secret+"_m.jpg";
	   
	    request.setAttribute("url", url);
	    request.setAttribute("img_id", String.valueOf(imgid));
		request.getSession().setAttribute("img_id", String.valueOf(imgid));
		System.out.println(val+" "+cat);
		return "makewish_start1.do";
	}
}
