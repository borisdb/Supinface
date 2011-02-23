/**
 * 
 */
package controllertest;

import models.User;

import org.junit.Before;
import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.GETFIELD;

import controllers.Auth;

import play.mvc.Http.Response;
import play.test.Fixtures;
import play.test.UnitTest;

/**
 * @author boris
 *
 */
public class AuthControllerTest extends UnitTest{
    
    //Supprime toutes les données dans la bdd avant chaque test
      @Before
      public void setup(){
          Fixtures.deleteAll();
          Fixtures.load("data.yml");         
      }
      
      @Test
      public void test()
      {
      }
}
