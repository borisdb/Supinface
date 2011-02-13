import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

	//Supprime toutes les données dans la bdd avant chaque test
	@Before
	public void setup(){
		Fixtures.deleteAll();
	}
	
    @Test
    public void tryConnectAsUser(){
    	//new User("78447", "pass", "Boris", "Dubois", "78447@supinfo.com").save();
    	
    	//Test
    	assertNotNull(User.connect("78447", "pass"));
    	assertNull(User.connect("12345", "pass"));
    	assertNull(User.connect("78447", "badpass"));
    
    }

}
