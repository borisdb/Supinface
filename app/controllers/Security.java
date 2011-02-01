package controllers;

import models.User;

public class Security extends Secure.Security{
	
	static boolean authenticate(String idBooster,String password)
	{
		return User.connect(idBooster, password)!= null;
	}

}
