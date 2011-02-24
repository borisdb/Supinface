/**
 * 
 */
package webservicetest;

import java.util.List;

import models.Group;

import org.junit.Before;
import org.junit.Test;

import play.mvc.Http.Response;
import play.test.Fixtures;
import play.test.FunctionalTest;

/**
 * @author boris
 *
 */
public class GroupWebServiceTest extends FunctionalTest{

  //Supprime toutes les données dans la bdd avant chaque test et recharge les données contentu dans data.yml
    @Before
    public void setup(){
        Fixtures.deleteAll();
        Fixtures.load("data.yml");
    }

    
    @Test
    public void groupListNotEmpty()
    {
        List<Group> groups=Group.findAll();
        assertNotNull(groups);
    }
        
    @Test
    public void getGroupById()
    {
        Group group = Group.find("byName", "supinface").first();
        Response response = GET("/group/getgroupbyid/"+group.id.toString()+"/");
        assertStatus(200, response);
        assertEquals(null, "{\"name\":\"supinface\",\"id\":"+group.id.toString()+"}", response.out.toString());
    }
    
    @Test
    public void getGroupMembers()
    {
        Group group = Group.find("byName", "supinface").first();
        Response response = GET("/group/getgroupmembers/"+group.id.toString()+"/");
        assertStatus(200, response);
    }
}
