/**
 * 
 */
package controllers;

import play.mvc.Http.Request;
import play.mvc.Http.Response;

import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

/**
 * @author boris
 *
 */
public class RenderJson extends play.mvc.results.Result{

	String json;
	/* (non-Javadoc)
	 * @see play.mvc.results.Result#apply(play.mvc.Http.Request, play.mvc.Http.Response)
	 */
	@Override
	public void apply(Request request, Response response) {

            setContentTypeIfNotSet(response, "application/json; charset=utf-8");
        try {
            response.out.write(json.getBytes("utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

	public RenderJson(Object o, ExclusionStrategy exclusionStrategy)
	{
		 Gson gson = new GsonBuilder().setExclusionStrategies 
		 (exclusionStrategy).serializeNulls().create(); 
		   json = gson.toJson(o); 
	}
}
