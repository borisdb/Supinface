/**
 * 
 */
package webservicetest;

import org.junit.Before;
import org.junit.Test;

import controllers.Auth;

import play.mvc.Http.Response;
import play.test.Fixtures;
import play.test.FunctionalTest;

/**
 * @author boris
 *
 */
public class AuthWebServiceTest extends FunctionalTest{

  //Supprime toutes les données dans la bdd avant chaque test et recharge les données contentu dans data.yml
    @Before
    public void setup(){
        Fixtures.deleteAll();
        Fixtures.load("data.yml");
    }
    
    @Test
    public void loginTest()
    {
        Response response = GET("/auth/login/78447/pass");
        assertStatus(200, response);
    }
    
    @Test
    public void checkAuthTest() throws Exception {
        Response response = GET("/auth/login/78447/pass");
        String token=response.out.toString();
        assertStatus(200, response);
        response= GET("/auth/check/"+token);
        assertEquals("true", response.out.toString());
    }
    
}
