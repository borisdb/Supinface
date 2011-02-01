package controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.User;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Admin extends Controller {

	@Before
	static void setConnectedUser(){
		if(Security.isConnected()){
			String wtf=Security.connected();
			System.out.println(wtf);
			User user = User.find("byIdBooster",Security.connected()).first();
			if(user==null)
			{
				Pattern p = Pattern.compile("\\.");
				String[] nomprenom=p.split(Security.connected());
				if(nomprenom.length==2)
				{
					user=User.find("byFirstNameAndLastName",nomprenom[0],nomprenom[1]).first();
				}
			}
			if(user==null)
			{
				// verifier email
				
				Pattern pattern = Pattern.compile("@");
				Matcher matcher=pattern.matcher(Security.connected());
				
				int i =0;
				while(matcher.find())
				{
					i+=1;
				}
				if(i==1)
				{
					user=User.find("byEmail",Security.connected()).first();
				}
			}

			if(user!=null)
			{
				renderArgs.put("user", user.firstName+" "+user.lastName);
			}
			
		}
	}
	
	public static void index()
	{
		render();
	}
	
}
