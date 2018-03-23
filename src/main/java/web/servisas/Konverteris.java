package web.servisas;

import org.json.JSONException;
import org.json.JSONObject;
import spark.Request;
import spark.Response;



public class Konverteris {

    	private static final int HTTP_NOT_FOUND = 404;
	//private static final int HTTP_CONFLICT = 409;
	private static TemperaturuKonteineris tk = new TemperaturuKonteineris();
	Konverteris() {}

	public static Object printTemp(Request request, Response response) {
 		return tk.getTemp();	
	}

 	public static String postTemp(Request request, Response response) {
		try{
			CityData cityObject = JsonTransformer.fromJson(request.body(), CityData.class);
			tk.addTemp(cityObject);
 		return "Ok";
		} catch (Exception e) {
			response.status(HTTP_NOT_FOUND);
		    	return "Blogai nurodytas formatas";
        	}	
	}

	public static String putTemp(Request request, Response response) {
		try{
			CityData cityObject = JsonTransformer.fromJson(request.body(), CityData.class);
            		int id = Integer.valueOf(request.params(":f"));
			tk.upTemp(id, cityObject);
 			return "Ok";
		} catch (Exception e) {
			response.status(HTTP_NOT_FOUND);
		    	return "Nepavyko rasti duomenų su " + request.params(":f") + " id";
        	}	
	}

	public static String deleteTemp(Request request, Response response) {
		try{
			int id = Integer.valueOf(request.params(":f"));
			tk.delTemp(Integer.valueOf(request.params(":f")));
	 		return "Ok";
		} catch (Exception e) {
			response.status(HTTP_NOT_FOUND);
		    	return "Nepavyko rasti duomenų su " + request.params(":f") + " id";
		}	
	}

	public static Object getTempSpecific(Request request, Response response){
		try{
			return tk.getTempSpec(request.params(":f"));
		} catch (Exception e) {
			response.status(HTTP_NOT_FOUND);
		    	return "Nepavyko rasti duomenų su " + request.params(":f") + " id";
		}	

	}
	
	public static JSONObject convertFtoC(double f) throws JSONException {
 
		JSONObject jsonObject = new JSONObject();
		double celsius; 
		celsius =  (f - 32)*5/9; 
		jsonObject.put("Farenheito reikšmė", f);
		jsonObject.put("Celsijaus reikšmė", celsius);	
		return jsonObject;
	}
}
