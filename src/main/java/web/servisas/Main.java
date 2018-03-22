package web.servisas;

import static spark.Spark.*;

import java.io.IOException;


public class Main {
   
    public static void main(String[] args) throws IOException {
	Konverteris k = new Konverteris();
        port(5000);

        path("/konverteris", () -> {

            get("", (request, response) -> {
                return k.printTemp(request, response);
            });

	    post("/:f", (request, response) -> {
                return k.postTemp(request, response);
            } , new JsonTransformer());
		
            put("/:f", (request, response) -> {
                return k.putTemp(request, response);
            }, new JsonTransformer());

            delete("/:f", (request, response) -> {
                return k.deleteTemp(request, response);
            }, new JsonTransformer());

        });
	
	exception(Exception.class, (e, request, response) -> e.printStackTrace());
	
        after((request, response) -> response.type("application/json"));

    }
    
}
