package movierecommendationsystem1;

import java.util.*;

public class RecommendationEngine{

    private List<UserEntry> mainUsers;
    private Map<Integer, String> movieTitles;
    private List<Integer> movieIds;

    public RecommendationEngine(List<UserEntry> mainUsers,Map<Integer, String> movieTitles, List<Integer> movieIds){
        this.mainUsers = mainUsers;
        this.movieTitles = movieTitles;
        this.movieIds = movieIds;
    }

    // Computes cosine similarity between two rating vectors
    public double cosineSimilarity(double[] a, double[] b){
        double dot = 0, normA = 0, normB = 0;
        int len = Math.min(a.length, b.length);
        for(int i = 0; i < len; i++){
            dot += a[i] * b[i];
            normA += a[i] * a[i];
            normB += b[i] * b[i];
        }
        if(normA == 0 || normB == 0){
            return 0;
        }
        return dot / (Math.sqrt(normA) * Math.sqrt(normB));
    }

    // Finds X most similar users from heap and returns their top K rated movies
    public List<String> getRecommendations(double[] targetRatings, int X, int K){
        MaxHeap heap = new MaxHeap();
        for(int u = 0; u < mainUsers.size(); u++){
            UserEntry user = mainUsers.get(u);
            UserEntry copy = new UserEntry(user.userId, user.ratings);
            copy.similarity = cosineSimilarity(targetRatings, user.ratings);
            heap.insert(copy);
        }
        List<String> recommendations = new ArrayList<>();
        int total = X * K;

        while(recommendations.size() < total && !heap.isEmpty()){
            UserEntry topUser = heap.extractMax();
            if(topUser == null){
                break;
            }
            List<int[]> ratedMovies = new ArrayList<>();
            for(int i = 0; i < topUser.ratings.length && i < movieIds.size(); i++){
                if(topUser.ratings[i] > 0){
                    ratedMovies.add(new int[]{movieIds.get(i), (int) topUser.ratings[i]});
                }
            }
            ratedMovies.sort((a, b) -> b[1] - a[1]);
            int count = 0;
            for(int m = 0; m < ratedMovies.size(); m++){
                if(count >= K){
                    break;
                }
                String title = movieTitles.getOrDefault(ratedMovies.get(m)[0], "Movie " + ratedMovies.get(m)[0]);
                recommendations.add(title);
                count++;
                if(recommendations.size() >= total){
                    break;
                }
            }
        }
        return recommendations;
    }
}
