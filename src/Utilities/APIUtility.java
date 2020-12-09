package Utilities;

import Models.NASAJsonResponse;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;
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
    public static NASAJsonResponse callNasaAPI(String searchText) throws IOException, InterruptedException {
        String jsonLocation = "src/Utilities/photosInfo.json";
        String uri = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=Cb8t7qeUST3IvXiY8IUJud7rmGjzBmbele3IYlzW" +searchText;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get(jsonLocation)));

        NASAJsonResponse photosResponse = getPhotosFromJSON(new File(jsonLocation));

        return photosResponse;

    }

    /**
     * This method recives JSON file, extracts photos data and
     * saves it in NASAJSONResponse
     * @param file - json file
     * @return
     */
    private static NASAJsonResponse getPhotosFromJSON(File file) {
        Gson gson = new Gson();
        NASAJsonResponse searchResult = null;

        try(
            FileReader fileReader = new FileReader(file);
            JsonReader jsonReader =  new JsonReader(fileReader);)
        {
             searchResult = gson.fromJson(jsonReader, NASAJsonResponse.class);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return searchResult;
    }
}
