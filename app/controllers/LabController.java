/**
 * 
 */
package controllers;

import models.Lab;
import models.MyExclusionStrategy;
import play.mvc.Controller;

/**
 * @author boris
 *
 */
public class LabController extends Controller{

    public void getLabs()
    {
        throw new RenderJson(Lab.all(),new MyExclusionStrategy(String.class));
    }
    
    public void getLab(Long id)
    {
        throw new RenderJson(Lab.findById(id),new MyExclusionStrategy(String.class));
    }
    
    public void getLabMembers(Long id)
    {
        Lab lab =Lab.findById(id);
        throw new RenderJson(lab.members,new MyExclusionStrategy(String.class));
    }
    
}
