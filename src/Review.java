public class Review {
    private String username;
    private double rating;
    private String comment;

    Review(String username,double rating,String comment){
        this.username=username;
        this.rating=rating;
        this.comment=comment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    @Override
    public String toString() {
        return "username: " + getUsername() +
                "\nrating: " + getRating() +
                "\ncomment: " + getComment();
    }
}
