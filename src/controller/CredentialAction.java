//Quincy
package controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.CommentDAO;
import model.Model;
import model.Chart1DAO;
import model.UserDAO;

import org.genericdao.MatchArg;
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
import databeans.UserBean;
import databeans.WishResultBean;
import formbeans.MakeWishForm;

public class CredentialAction extends Action {
	private static final String PROTECTED_RESOURCE_URL = "https://api.twitter.com/1.1/account/verify_credentials.json";
	private UserDAO userDAO;

	public CredentialAction(Model model) {
		userDAO = model.getUserDAO();
	}

	public String getName() {
		return "credential.do";
	}

	public String perform(HttpServletRequest request) {

		OAuthService service = new ServiceBuilder()
				.provider(TwitterApi.SSL.class).apiKey(AuthInfo.API_KEY)
				.apiSecret(AuthInfo.API_SECRET).build();

		Token accessToken;

		Token requestToken = new Token(request.getParameter("oauth_token"),
				request.getParameter("oauth_verifier"));
		Verifier verifier = new Verifier(request.getParameter("oauth_verifier"));
		accessToken = service.getAccessToken(requestToken, verifier);
		request.getSession().setAttribute("accessToken", accessToken);

		OAuthRequest twitterRequest = new OAuthRequest(Verb.GET,
				PROTECTED_RESOURCE_URL);
		service.signRequest(accessToken, twitterRequest);

		Response response = twitterRequest.send();
		String result = response.getBody();

		InputStream is;
		String userName = new String();
		try {
			is = new ByteArrayInputStream(result.getBytes("UTF-8"));
			JsonReader reader = Json.createReader(is);
			JsonObject account = reader.readObject();
			userName = account.getString("screen_name");

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getSession().setAttribute("screen_name", userName);

		try {
			UserBean[] array = userDAO.match(MatchArg.equals("username",
					userName));
			if (array.length == 0) {
				UserBean user = new UserBean();
				user.setUserName(userName);
				userDAO.createAutoIncrement(user);
			}
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(userName);
		return "credential.jsp";
	}
}
