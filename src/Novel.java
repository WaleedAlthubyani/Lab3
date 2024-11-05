import java.util.ArrayList;

public class Novel extends Book{
    private String genre;

    Novel(String title, String auteur, String ISBN, double price, int stock, ArrayList<Review> review, String genre){
        super(title,auteur,ISBN,price,stock,review);
        this.genre=genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String getMediaType() {
        return (isBestseller()) ? "Bestselling Novel":"Novel";
    }

    @Override
    public String toString() {
        return super.toString()+"\nGenre: "+getGenre();
    }
}
