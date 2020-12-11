package Models;

import com.google.gson.annotations.SerializedName;

/**
 * This class stores hiight-level response that API call will return
 */
public class NASAJsonResponse {

    @SerializedName("photos")
    private PhotoUnit[] results;

    public NASAJsonResponse(PhotoUnit[] results) {
        setResults(results);
    }

    public PhotoUnit[] getResults() {
        return results;
    }

    public void setResults(PhotoUnit[] results) {
        this.results = results;
    }
}
