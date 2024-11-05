import java.util.ArrayList;

public class Book extends Media {
    private int stock;
    private ArrayList<Review> review;

    Book(String title,String auteur,String ISBN,double price,int stock,ArrayList<Review> review){
        super(title,auteur,ISBN,price);
        this.stock=stock;
        this.review=review;
    }

    public ArrayList<Review> getReview() {
        return review;
    }

    public void setReview(ArrayList<Review> review) {
        this.review = review;
    }

    public void addReview(Review r){
        review.add(r);
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getAverageRating(){
        if (review.isEmpty())
            return 0;

        double sum=0;
        for (Review rating : review) {
            sum += rating.getRating();
        }

        return sum/review.size();
    }

    public void purchase(User user){
        if (getStock()>0){
            user.addPurchaseMediaList(user.getShoppingCart().getFirst());
            setStock(getStock()-1);
        }
        else{
            System.out.println("Sorry "+user.getShoppingCart().getFirst().getTitle()+" is out of stock");

        }
    }

    public boolean isBestseller(){
        return getAverageRating() >= 4.5;
    }

    public void restock(int quantity){
        if (quantity<0)
            System.out.println("Restock failed");
        else{
            stock=quantity;
            System.out.println("Restock successful");
        }
    }

    @Override
    public String getMediaType() {
        return (isBestseller()) ? "Bestselling Book" : "Book";
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nStuck: " + getStock()+
                "\nReviews: " + getReview();
    }
}
