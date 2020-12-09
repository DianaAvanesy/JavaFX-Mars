package Models;

import com.google.gson.annotations.SerializedName;

public class NASAJsonResponse {

    @SerializedName("photos")
    private PhotoUnit[] results;

    public NASAJsonResponse(PhotoUnit[] results) {
        this.results = results;
    }

    public PhotoUnit[] getResults() {
        return results;
    }

    public void setResults(PhotoUnit[] results) {
        this.results = results;
    }
}
