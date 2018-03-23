package web.servisas;

import static spark.Spark.*;

import java.io.IOException;
import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;

public class Main {
   
    public static void main(String[] args) throws IOException {
	Konverteris k = new Konverteris();
        port(5000);

        path("/locations", () -> {

            get("", (request, response) -> {
                return k.printTemp(request, response);
            }, new JsonTransformer());
		
	    get("/city/:f", (request, response) -> {
                return k.getTempSpecific(request, response);
            }, new JsonTransformer());

	    post("", (request, response) -> {
                return k.postTemp(request, response);
            } , new JsonTransformer());
		
            put("/:f", (request, response) -> {
                return k.putTemp(request, response);
            }, new JsonTransformer());

            delete("/:f", (request, response) -> {
                return k.deleteTemp(request, response);
            }, new JsonTransformer());

        });
	
	exception(Exception.class, (e, request, response) -> {
		response.status(HTTP_BAD_REQUEST);
		e.printStackTrace();
	});
	
        after((request, response) -> response.type("application/json"));

    }
    
}
