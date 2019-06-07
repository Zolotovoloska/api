package api.client.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiClient {
    protected final OkHttpClient client;
    protected final String url;
    protected static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    protected static final MediaType TEXT = MediaType.parse("text/html; charset=utf-8");
    protected static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiClient.class);



    public ApiClient(CookieStore cookieStore) {
        url = "";
        client = new OkHttpClient.Builder()
                .cookieJar(cookieStore)
                .build();
    }
}
