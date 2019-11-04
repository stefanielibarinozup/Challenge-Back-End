package br.com.zup.challenge;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.*;

public class App {

    private static final String BASE_URL = "https://www.reddit.com/r/programming/";
    private static ArrayList<String> listTitle;

    public static void main(String[] agrs) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        listTitle = filterResult(response.body());
        ordenaLista(listTitle);
        for (String title : ordenaLista(listTitle)) {
            System.out.println(title);
        }
    }

    public static ArrayList<String> filterResult(String response) {
        int cont = 0;
        ArrayList<String> listToOrdena = new ArrayList<String>();
        String[] filterResult = response.split(",");
        List<String> list = Arrays.asList(filterResult);
        for (String itemList : list) {
            if (itemList.length() >= 6) {
                String itemListItem = itemList.substring(1, 6);
                if (itemListItem.equals("title") && cont < 20) {
                    if (!itemList.isEmpty()) {
                        itemList = itemList.substring(8, itemList.lastIndexOf("\""));
                        if (itemList.length() > 1) {
                            listToOrdena.add(itemList);
                            cont++;
                        }
                    }
                }
            }
        }
        return listToOrdena;
    }

    public static ArrayList<String> ordenaLista(ArrayList<String> listToOrdena) {
        int i;
        String key;
        int n = listToOrdena.size();
        for (i = 1; i < n; ++i) {
            key = listToOrdena.get(i);
            int j = i - 1;
            while (j >= 0 && listToOrdena.get(j).compareTo(key) > 0) {
                listToOrdena.set(j + 1, listToOrdena.get(j));
                j = j - 1;
            }
            listToOrdena.set(j + 1, key);
        }
        return listToOrdena;
    }
}
