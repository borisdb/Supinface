/**
 * 
 */
package controllers.renders;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import play.mvc.Http;
import play.mvc.Http.Request;
import play.mvc.Http.Response;
import play.mvc.results.Result;

/**
 * @author boris
 *
 */
public class UnauthorizedResult extends Result {

    String error;
    
    public UnauthorizedResult(String error)
    {
        super(error);
        this.error = error;
    }
    
    /* (non-Javadoc)
     * @see play.mvc.results.Result#apply(play.mvc.Http.Request, play.mvc.Http.Response)
     */
    @Override
    public void apply(Request request, Response response) {
        response.status = Http.StatusCode.UNAUTHORIZED;
        try {
            response.out.write(error.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 
    

}
