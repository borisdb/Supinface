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
public class SkillWebServiceTest extends FunctionalTest{

  //Supprime toutes les données dans la bdd avant chaque test et recharge les données contentu dans data.yml
    @Before
    public void setup(){
        Fixtures.deleteAll();
        Fixtures.load("data.yml");
    }
    
    @Test
    public void getSkillByUserId()
    {
        Response response = GET("/skill/getskillbyuserid/1/");
        assertStatus(200, response);
    }
    
}
