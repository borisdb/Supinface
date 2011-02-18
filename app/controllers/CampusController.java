package controllers;

import com.google.gson.ExclusionStrategy;
import models.Campus;
import models.MyExclusionStrategy;
import models.User;
import play.mvc.Controller;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: boris
 * Date: 12/02/11
 * Time: 14:36
 */
public class CampusController extends Controller{
    public static void getCampuses()
    {
        List<Campus> campuses = Campus.findAll();
        throw new RenderJson(campuses,new MyExclusionStrategy(String.class));
    }

    public static void getUserByCampus(Long id)
    {
        Campus campus=Campus.findById(id);
        throw new RenderJson(campus.members,new MyExclusionStrategy(String.class));
    }
}
