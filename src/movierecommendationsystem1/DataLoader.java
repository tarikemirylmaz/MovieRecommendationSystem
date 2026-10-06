package movierecommendationsystem1;

import java.io.*;
import java.util.*;

public class DataLoader{

    // Reads user-movie matrix from CSV and returns list of UserEntry objects
    public static List<UserEntry> loadUsers(String filePath) throws IOException{
        List<UserEntry> users = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String headerLine = br.readLine();
        if(headerLine == null){
            br.close();
            return users;
        }
        String[] headers = headerLine.split(",");
        int numMovies = headers.length - 1;
        String line;
        while((line = br.readLine()) != null){
            if(line.trim().isEmpty()){
                continue;
            }
            String[] parts = line.split(",");
            int userId = Integer.parseInt(parts[0].trim());
            double[] ratings = new double[numMovies];
            for(int i = 1; i < parts.length; i++){
                ratings[i - 1] = Double.parseDouble(parts[i].trim());
            }
            users.add(new UserEntry(userId, ratings));
        }
        br.close();
        return users;
    }

    // Reads movies CSV and returns a map of movieId to title
    public static Map<Integer, String> loadMovies(String filePath) throws IOException{
        Map<Integer, String> movies = new LinkedHashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        br.readLine();
        String line;
        while((line = br.readLine()) != null){
            if(line.trim().isEmpty()){
                continue;
            }
            int firstComma = line.indexOf(',');
            if(firstComma < 0){
                continue;
            }
            int movieId = Integer.parseInt(line.substring(0, firstComma).trim());
            String rest = line.substring(firstComma + 1);
            int lastComma = rest.lastIndexOf(',');
            String title;
            if(lastComma >= 0){
                title = rest.substring(0, lastComma).trim();
            }else{
                title = rest.trim();
            }
            title = title.replaceAll("^\"|\"$", "");
            movies.put(movieId, title);
        }
        br.close();
        return movies;
    }

    // Reads movies CSV and returns a list of movie IDs
    public static List<Integer> getMovieIds(String filePath) throws IOException{
        List<Integer> ids = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        br.readLine();
        String line;
        while((line = br.readLine()) != null){
            if(line.trim().isEmpty()){
                continue;
            }
            int firstComma = line.indexOf(',');
            if(firstComma < 0){
                continue;
            }
            ids.add(Integer.parseInt(line.substring(0, firstComma).trim()));
        }
        br.close();
        return ids;
    }
}
