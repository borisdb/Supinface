/**
 * 
 */
package webservicetest;

import models.Campus;

import org.junit.Before;
import org.junit.Test;

import play.mvc.Http.Response;
import play.test.Fixtures;
import play.test.FunctionalTest;

/**
 * @author boris
 *
 */
public class CampusWebServiceTest extends FunctionalTest{

  //Supprime toutes les données dans la bdd avant chaque test et recharge les données contentu dans data.yml
    @Before
    public void setup(){
        Fixtures.deleteAll();
        Fixtures.load("data.yml");
    }
    
    @Test
    public void getAllTest()
    {
        Response response = GET("/campus/getall/");
        assertStatus(200, response);
    }
    
    @Test
    public void getUserByCampus()
    {
        Campus campus=Campus.find("byName", "Montréal").first();
        Response response = GET("/campus/getuserbycampus/"+campus.id+"/");
        assertStatus(200, response);
    }
    
}
