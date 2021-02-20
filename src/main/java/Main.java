import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class Main {

    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST = "forecasts";
    private static final String LOCATIONS = "locations";
    private static final String API_VERSION = "v1";
    private static final String FORECAST_TYPE = "daily";
    private static final String FORECAST_PERIOD = "5day";
    private static final String API_KEY = "hfhRS3dFcC4L9x1SojG1fq30UJAGpACW";
    private static final String CITY_KEY = "294021";
    private static final String CITIES = "topcities";
    private static final String TOP_50 = "50";

    public static void main(String[] args) throws IOException {

        System.out.println("TOP-50");
        //http://dataservice.accuweather.com/locations/v1/topcities/{group}

        OkHttpClient clientTop = new OkHttpClient();
        HttpUrl urlTop = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(API_VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(TOP_50)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();

        System.out.println(urlTop.toString());

        Request requesthttpTop = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(urlTop)
                .build();

        String jsonResponseTop = clientTop.newCall(requesthttpTop).execute().body().string();
        System.out.println(jsonResponseTop);

        System.out.println();
        System.out.println("Weather in Moscow for the next 5 days");

        // http://dataservice.accuweather.com/forecasts/v1/daily/5day/{locationKey}

        OkHttpClient client = new OkHttpClient();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(FORECAST)
                .addPathSegment(API_VERSION)
                .addPathSegment(FORECAST_TYPE)
                .addPathSegment(FORECAST_PERIOD)
                .addPathSegment(CITY_KEY)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();

        System.out.println(url.toString());


        Request requesthttp = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();

        String jsonResponse = client.newCall(requesthttp).execute().body().string();
        System.out.println(jsonResponse);


        System.out.println();


    }


}


