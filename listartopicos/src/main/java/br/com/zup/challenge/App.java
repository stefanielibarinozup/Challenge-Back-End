package br.com.zup.challenge;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

public class App {

    private static final String BASE_URL = "https://www.reddit.com/r/programming/";

    public static void main(String[] agrs) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .build();

       HttpResponse<String> response =  client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            //filterResult(response.body());


    }

     public static void filterResult (String response ) {

//        String[] filterResult = response.split(",");
//
//         List<String> list = Arrays.asList(filterResult);
//         for(String itemList : list){
//             if(itemList.length() >= 6){
//                 String itemListItem = itemList.substring(1, 6);
//                 if(itemListItem.equals("title")){
//                     System.out.println(itemList);
//                 }
//             }
//         }
    }
}
