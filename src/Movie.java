import java.util.ArrayList;

public class Movie extends Media{
    private int duration;

    Movie(String title,String auteur,String ISBN,double price,int duration){
        super(title, auteur, ISBN, price);
        this.duration=duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void watch(User user){
        user.addPurchaseMediaList(user.getShoppingCart().getFirst());
    }

    public ArrayList<Movie> recommendSimilarMovies(ArrayList<Movie> movieCatalog){
        ArrayList<Movie> recommendations=new ArrayList<>();

        for (Movie m : movieCatalog){
            if (m.getAuteur().equals(getAuteur())){
                recommendations.add(m);
            }
        }

        return recommendations;
    }

    @Override
    public String getMediaType() {
        return (duration>=120) ? "Long Movie":"Movie";
    }

    @Override
    public String toString() {
        return super.toString()+"\nDuration: " + getDuration();
    }
}
