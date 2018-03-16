package web.servisas;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;


@Path("konverteris")
public class Konverteris {

	  @GET
	  @Produces("application/json")
	  public Response convertFtoC() throws JSONException {
 
		JSONObject jsonObject = new JSONObject();
		Double fahrenheit = 98.24;
		Double celsius;
		celsius = (fahrenheit - 32)*5/9; 
		jsonObject.put("Celsijaus reikšmė", celsius);
		jsonObject.put("Farenheito reikšmė", fahrenheit); 
 
		String result = "\n\nF to C konverterio rezultatas: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	  }
 
	  @Path("{f}")
	  @GET
	  @Produces("application/json")
	  public Response convertFtoCfromInput(@PathParam("f") float f) throws JSONException {
 
		JSONObject jsonObject = new JSONObject();
		float celsius;
		celsius =  (f - 32)*5/9; 
		jsonObject.put("Celsijaus reikšmė", celsius);
		jsonObject.put("Farenheito reikšmė", f); 
		
		String result = "\n\nF to C konverterio rezultatas: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	  }
}
