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
            //System.out.println(response.body());
            filterResult(response.body());

    }

     public static void filterResult (String response ) {

        String[] filterResult = response.split(",");
        int cont = 0;

         List<String> list = Arrays.asList(filterResult);

         for(String itemList : list){
             if(itemList.length() >= 6){
                 String itemListItem = itemList.substring(1, 6);
                 if(itemListItem.equals("title") && cont <20){
                     cont ++;
                     itemList = itemList.substring(8, itemList.lastIndexOf("\"") );
                     //System.out.println(itemList);
                 }
             }
         }
         int j;
         int key;
         int i;

         for (j = 1; j < vetor.length; j++)
         {
             key = vetor[j];
             for (i = j - 1; (i >= 0) && (vetor[i] > key); i--)
             {
                 vetor[i + 1] = vetor[i];
             }
             vetor[i + 1] = key;
         }

    }
}
