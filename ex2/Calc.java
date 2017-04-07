
package ex2;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

public class Calc {
	
    public String doCalc(String arg) {    
    	
    	BigDecimal a;
 	    BigDecimal b;
 	    BigDecimal c;
 	    
 	    String arr[];
 	    
 	    MathContext mc = new MathContext(10);
 	    Map<String, Method> sign = new HashMap<String, Method>();
    	    try {
    	    	sign.put("-", BigDecimal.class.getMethod("subtract", BigDecimal.class));
    	    	sign.put("+", BigDecimal.class.getMethod("add", BigDecimal.class));
    	    	sign.put("*", BigDecimal.class.getMethod("multiply", BigDecimal.class));
    	    	sign.put("/", BigDecimal.class.getMethod("divide", BigDecimal.class,MathContext.class));              
    	    	arr = arg.split(" "); 

                a = new BigDecimal(arr[0]);
                b = new BigDecimal(arr[2]);
                c = (BigDecimal) sign.get(arr[1]).invoke(a, b, mc);
                
                return String.valueOf(c);
                
            } catch (Exception e) {
                return "Invalid command to calc";
            }
    	    
    }
 

}
