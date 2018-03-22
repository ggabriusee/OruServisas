package web.servisas;

import org.json.JSONException;
import org.json.JSONObject;
import spark.Request;
import spark.Response;


public class Konverteris {
	
	private static TemperaturuKonteineris tk = new TemperaturuKonteineris(convertFtoC(32));
	Konverteris() {}

	public static Object printTemp(Request request, Response response) throws JSONException {
 		return tk.getTemp();	
	}

 	public static String postTemp(Request request, Response response) throws JSONException {
		JSONObject jsonObject = convertFtoC(Double.parseDouble(request.params(":f")));
		tk.addTemp(jsonObject);
 		return "Ok";	
	}

	public static String putTemp(Request request, Response response) throws JSONException {
		JSONObject jsonObject = new JSONObject(request.body());
		JSONObject trueObject = convertFtoC(jsonObject.getDouble("Farenheito reikšmė"));
		double f = Double.parseDouble(request.params(":f"));
		tk.upTemp(f, trueObject);
 		return "Ok";	
	}

	public static String deleteTemp(Request request, Response response) throws JSONException {
		tk.delTemp(Double.parseDouble(request.params(":f")));
 		return "Ok";	
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
