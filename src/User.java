import java.util.ArrayList;

public class User {
    private String username;
    private String email;
    private ArrayList<Media> purchaseMediaList=new ArrayList<>();
    private ArrayList<Media> shoppingCart=new ArrayList<>();

    User(String username,String email){
        this.username=username;
        this.email=email;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Media> getPurchaseMediaList() {
        return purchaseMediaList;
    }

    public void addPurchaseMediaList(Media item) {
        purchaseMediaList.add(item);
    }

    public ArrayList<Media> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ArrayList<Media> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void setPurchaseMediaList(ArrayList<Media> purchaseMediaList) {
        this.purchaseMediaList = purchaseMediaList;
    }

    public void addToCart(Media media){
        shoppingCart.add(media);
    }

    public void removeFromCart(Media media){
        shoppingCart.remove(media);
    }


    public void checkout(){
        if (shoppingCart.isEmpty()){
            System.out.print("");//so that the compiler will shut up about an empty if statement
        }else{ if (shoppingCart.getFirst() instanceof Book || shoppingCart.getFirst() instanceof Novel || shoppingCart.getFirst() instanceof AcademicBook){
                ((Book) shoppingCart.getFirst()).purchase(this);
            } else if (shoppingCart.getFirst() instanceof Movie) {
                ((Movie) shoppingCart.getFirst()).watch(this);
            }else if (shoppingCart.getFirst() instanceof Music)
                ((Music) shoppingCart.getFirst()).listen(this);
            removeFromCart(shoppingCart.getFirst());
            checkout();
        }

    }

    public void addReview(double rating,String comment,Media b){
        if (b instanceof Book){
            Review r = new Review(getUsername(),rating,comment);
            ((Book) b).addReview(r);}
    }

    @Override
    public String toString() {
        return "Username: "+getUsername()+
                "\nEmail: "+getEmail()+
                "\nPurchased list: " +getPurchaseMediaList()+
                "\nShopping cart: "+getShoppingCart();
    }
}
