/**
 * 
 */
package webservicetest;

import org.junit.Before;
import org.junit.Test;

import play.mvc.Http.Response;
import play.test.Fixtures;
import play.test.FunctionalTest;

/**
 * @author boris
 *
 */
public class UserWebServiceTest extends FunctionalTest{

    //Supprime toutes les données dans la bdd avant chaque test et recharge les données contentu dans data.yml
    @Before
    public void setup(){
        Fixtures.deleteAll();
        Fixtures.load("data.yml");
    }
    
    @Test
    public void getUserByIdBooster() throws Exception {
        Response response = GET("/user/getuserbyidbooster/78447/");
        assertStatus(200, response);
        
        response=GET("/user/getuserbyidbooster/12345/");
        assertEquals(null, "null", response.out.toString());
    }
    
    @Test
    public void getUserById()
    {
        Response response = GET("/user/getuserbyid/1/");
        assertStatus(200, response);
        
        response=GET("/user/getuserbyid/19293836/");
        assertEquals(null, "null", response.out.toString());
    }
    
    @Test
    public void getAllUser()
    {
        Response response = GET("/user/getall/");
        assertStatus(200, response);
    }
    
}
