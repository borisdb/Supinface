package controllers;

import play.mvc.Controller;
import models.User;

public class Auth extends Controller{

	public static void login(String login, String password)
	{
		String msg="bad login/password";
		User user=User.connect(login, password);
		if(user!=null){
		renderJSON(user);
		}
		else{renderJSON(msg);}
//		if(user!=null)
//		{
//			msg=user.toString();
//		}
//		return msg;
	
	}
	
}
