package Utilities;

import Models.NASAJsonResponse;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
*
 */
public class APIUtility {

    /**
     * This method will recieve photos String and send it to NASAJSONResponse
     */
    public static void callNasaAPI(String searchText) throws IOException, InterruptedException {
        String jsonLocation = "src/Utilities/photosInfo.json";
        String uri = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY" +searchText;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get(jsonLocation)));



    }
}
