/**
 * 
 */
package models;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/**
 * @author boris
 *
 */
public class MyExclusionStrategy implements ExclusionStrategy{

    private final Class<?> typeToSkip;

    public MyExclusionStrategy(Class<?> typeToSkip) {
      this.typeToSkip = typeToSkip;
    }
    
    /* (non-Javadoc)
     * @see com.google.gson.ExclusionStrategy#shouldSkipField(com.google.gson.FieldAttributes)
     */

    public boolean shouldSkipField(FieldAttributes f) {
    	 return f.getAnnotation(NoRender.class) != null; 
    }

    /* (non-Javadoc)
     * @see com.google.gson.ExclusionStrategy#shouldSkipClass(java.lang.Class)
     */
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }

}
