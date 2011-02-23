/**
 * 
 */
package controllertest;

import models.User;

import org.junit.Before;
import org.junit.Test;

import play.test.Fixtures;
import play.test.UnitTest;

/**
 * @author boris
 *
 */
public class UserControllerTest extends UnitTest{
    
  //Supprime toutes les données dans la bdd avant chaque test
    @Before
    public void setup(){
        Fixtures.deleteAll();
        Fixtures.load("data.yml");
    }
    
    @Test
    public void tryConnectAsUserByIdBooster(){
        assertNotNull(User.connect("78447", "pass"));
        assertNull(User.connect("12345", "pass"));
        assertNull(User.connect("78447", "badpass"));
    }
    
}
