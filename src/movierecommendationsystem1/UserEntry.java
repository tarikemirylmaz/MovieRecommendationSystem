package movierecommendationsystem1;

public class UserEntry{
    public int userId;
    public double[] ratings;
    public double similarity;

    public UserEntry(int userId, double[] ratings){
        this.userId = userId;
        this.ratings = ratings;
        this.similarity = 0.0;
    }
}
