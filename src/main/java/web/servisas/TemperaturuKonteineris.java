package web.servisas;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class TemperaturuKonteineris{

	private ArrayList<JSONObject> jsonArray = new ArrayList<JSONObject>();

	TemperaturuKonteineris(JSONObject jsonObj){
		jsonArray.add(jsonObj);
	}
	
	public void delTemp(double f){
		for (int i = 0; i < jsonArray.size(); i++) {
			if(jsonArray.get(i).getDouble("Farenheito reikšmė") == f){
				jsonArray.remove(i);
			}
		}
	}
	
	public void upTemp(double f, JSONObject jsonObj){
		for (int i = 0; i < jsonArray.size(); i++) {
			if(jsonArray.get(i).getDouble("Farenheito reikšmė") == f){
				jsonArray.get(i).put("Farenheito reikšmė", jsonObj.getDouble("Farenheito reikšmė"));
				jsonArray.get(i).put("Celsijaus reikšmė", jsonObj.getDouble("Celsijaus reikšmė"));
			}
		}
	}

	public void addTemp(JSONObject jsonObj){
		jsonArray.add(jsonObj);
	}
	public ArrayList<JSONObject> getTemp(){
		return jsonArray;
	}











}
