/**
 * 
 */
package controllers;

import models.Group;
import models.MyExclusionStrategy;
import play.mvc.Controller;

/**
 * @author boris
 *
 */
public class GroupController extends Controller{

    public static void getGroupById(Long id)
    {
        throw new RenderJson(Group.findById(id), new MyExclusionStrategy(String.class));
    }
    
    public static void getMembersByGroup(Long id){
        Group group=Group.findById(id);
        throw new RenderJson(group.members, new MyExclusionStrategy(String.class));
    }
    
}
