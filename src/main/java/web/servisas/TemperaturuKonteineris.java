package web.servisas;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class TemperaturuKonteineris{

	private ArrayList<JSONObject> jsonArray = new ArrayList<JSONObject>();

	TemperaturuKonteineris(JSONObject jsonObj){
		jsonArray.add(jsonObj);
	}
	
	public void delTemp(double f) throws JSONException, Exception{
		boolean check=false;
		for (int i = 0; i < jsonArray.size(); i++) {
			if(jsonArray.get(i).getDouble("Farenheito reikšmė") == f){
				check=true;
				jsonArray.remove(i);
				break;
			}
		}
		if(check==false){throw new Exception("Tokios reikšmės nėra");}
	}
	
	public void upTemp(double f, JSONObject jsonObj) throws JSONException, Exception {
		boolean check=false;
		for (int i = 0; i < jsonArray.size(); i++) {
			if(jsonArray.get(i).getDouble("Farenheito reikšmė") == f){
				check=true;
				jsonArray.get(i).put("Farenheito reikšmė", jsonObj.getDouble("Farenheito reikšmė"));
				jsonArray.get(i).put("Celsijaus reikšmė", jsonObj.getDouble("Celsijaus reikšmė"));
				break;
			}
		}
		if(check==false){throw new Exception("Tokios reikšmės nėra");}
	}

	public void addTemp(JSONObject jsonObj) throws JSONException, Exception {
		for (int i = 0; i < jsonArray.size(); i++) {
			if(jsonArray.get(i).getDouble("Farenheito reikšmė") == jsonObj.getDouble("Farenheito reikšmė")){
				throw new Exception("Jau yra tokia reikšmė");
			}
		}
		jsonArray.add(jsonObj);
	}
	public ArrayList<JSONObject> getTemp(){
		return jsonArray;
	}











}
