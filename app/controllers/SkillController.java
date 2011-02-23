/**
 * 
 */
package controllers;

import models.MyExclusionStrategy;
import models.Skill;
import play.mvc.Controller;

/**
 * @author boris
 *
 */
public class SkillController extends Controller{

    public static void newSkill()
    {
        
    }
    
    public static void getSkillById()
    {
        
    }
    
    public static void getUserSkill(Long id){
        throw new RenderJson(Skill.find("byOwner.id", id).fetch(),new MyExclusionStrategy(String.class));
    }
    
}
