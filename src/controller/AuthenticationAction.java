//Quincy
package controller;

import java.util.ArrayList;
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

public class AuthenticationAction extends Action {
	
//	private Chart1DAO cDAO;
	private CommentDAO commentDAO;
	private static final String PROTECTED_RESOURCE_URL = "https://api.twitter.com/1.1/statuses/update.json";

	public AuthenticationAction(Model model) {
//		cDAO = model.getChart1DAO();
		commentDAO = model.getCommentDAO();
	}

	public String getName() { return "authentication.do"; }
    
    public String perform(HttpServletRequest request) {
    	
    	
    	
    	OAuthService service = new ServiceBuilder()
		.provider(TwitterApi.SSL.class).apiKey(AuthInfo.API_KEY)
		.apiSecret(AuthInfo.API_SECRET).callback("http://127.0.0.1:8080/Task8Genie/credential.do").build();
    	
    	
    	Token requestToken = service.getRequestToken();
		String authUrl = service.getAuthorizationUrl(requestToken);
		request.setAttribute("url", authUrl); 
		
	
    	return authUrl;
    }
}
