//lily
package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.CommentDAO;
import model.Model;
import model.Chart1DAO;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import databeans.CommentBean;
import databeans.WishResultBean;
import formbeans.MakeWishForm;

public class DiscussAction extends Action {

	// private Chart1DAO cDAO;
	private CommentDAO commentDAO;
	private static final String PROTECTED_RESOURCE_URL = "https://api.twitter.com/1.1/statuses/update.json";

	public DiscussAction(Model model) {
		// cDAO = model.getChart1DAO();
		commentDAO = model.getCommentDAO();
	
	}

	public String getName() {
		return "discuss.do";
	}

	public String perform(HttpServletRequest request) {
	

    	
			
//    		System.out.println("~~~~~~~~~~~"+status);
    		OAuthService service = new ServiceBuilder()
    					.provider(TwitterApi.SSL.class).apiKey(AuthInfo.API_KEY)
    					.apiSecret(AuthInfo.API_SECRET).build();

//    	    Token requestToken = new Token(AuthInfo.ACCESS_TOKEN, AuthInfo.ACCESS_TOKEN_SECRET);
    		
    		
    		Token accessToken;
    		if(request.getSession().getAttribute("accessToken") == null){
    			Token requestToken = new Token(request.getParameter("oauth_token"),request.getParameter("oauth_verifier"));
    			Verifier verifier = new Verifier(request.getParameter("oauth_verifier"));
    			accessToken = service.getAccessToken(requestToken, verifier);
    			request.getSession().setAttribute("accessToken", accessToken);
        	}
      
    	
    		else
    			accessToken = (Token) request.getSession().getAttribute("accessToken");
    		
    		if(request.getParameter("status") == null)
    			return "discuss.jsp";
//    		Token requestToken = service.getRequestToken();
//    		String authUrl = service.getAuthorizationUrl(requestToken);
//    		request.setAttribute("url", authUrl);
//    		System.out.println(authUrl);
    		
//    		Verifier verifier = new Verifier(request.getParameter("oauth_verifier"));
//    		System.out.println(verifier);
//    		Token accessToken = service.getAccessToken(requestToken, verifier);
    		
    		String status = request.getParameter("status");
    		OAuthRequest twitterRequest = new OAuthRequest(Verb.POST,
    	    								PROTECTED_RESOURCE_URL);
    	  
//    	    String status = "hahahethere";
    		String preStatus = "#MakeAWish ";
    	
    	    twitterRequest.addQuerystringParameter("status", preStatus + status);
    	    
    	    service.signRequest(accessToken, twitterRequest);
    	  
    	    Response response = twitterRequest.send();
    		
    		
    		request.setAttribute("status", preStatus + status);
    		String username=(String) request.getSession().getAttribute("screen_name");
    		
    		
    		//store in db
    		CommentBean comment = new CommentBean();
    		comment.setComment(preStatus + status);
    		comment.setPhotoId(Integer.parseInt(request.getParameter("img_id")));
    		comment.setUserName(username);
    		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    		Date d = new Date();
    		String s = dateFormat.format(d);
    		comment.setDate(s);
    		try {
				commentDAO.createAutoIncrement(comment);
			} catch (RollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		
    		request.getSession().setAttribute("img_id", request.getParameter("img_id"));
    		
    		return "makewish_start1.do";
    }
}
