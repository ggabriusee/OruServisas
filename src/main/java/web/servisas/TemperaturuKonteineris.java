package web.servisas;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class TemperaturuKonteineris{

	private ArrayList<CityData> cityArray = new ArrayList<CityData>();

	TemperaturuKonteineris(){
		cityArray.add(new CityData(1, 0, "Vilnius", "2018-02-02"));
		cityArray.add(new CityData(2, 15, "Kaunas", "2018-04-02"));
		cityArray.add(new CityData(3, -20, "Vilnius", "2018-12-30"));
	}
	
	public void delTemp(int id) throws Exception{
		boolean check=false;
		for (int i = 0; i < cityArray.size(); i++) {
			if(cityArray.get(i).getId() == id){
				check=true;
				cityArray.remove(i);
				break;
			}
		}
		if(check==false){throw new Exception("Tokios reikšmės nėra");}
	}
	
	public void upTemp(int f, CityData cityObj) throws Exception {
		boolean check=false;
		for (int i = 0; i < cityArray.size(); i++) {
			if(cityArray.get(i).getId() == f){
				check=true;
				cityArray.get(i).setTemperature(cityObj.getTemperature());
				cityArray.get(i).setCity(cityObj.getCity());
				cityArray.get(i).setDate(cityObj.getDate());
				break;
			}
		}
		if(check==false){throw new Exception("Tokios reikšmės nėra");}
	}

	public void addTemp(CityData cityObj)  {
		cityObj.setId(cityArray.get(cityArray.size()-1).getId()+1);
		cityArray.add(cityObj);
	}
	public ArrayList<CityData> getTemp(){
		return cityArray;
	}
	public Object getTempSpec(String s) throws Exception {
		boolean check=false;
		ArrayList<CityData> cityMas = new ArrayList<CityData>();
		for (int i = 0; i < cityArray.size(); i++) {
			if(cityArray.get(i).getCity().equals(s)){
				check=true;
				cityMas.add(cityArray.get(i));
			}
		}
		if(check==false){throw new Exception("Tokios reikšmės nėra");}
		return cityMas;
	}

}
