import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Store {
    private ArrayList<User> user=new ArrayList<>();
    private ArrayList<Media> media=new ArrayList<>();

    public ArrayList<Media> getMedia() {
        return media;
    }

    public void setMedia(ArrayList<Media> media) {
        this.media = media;
    }

    public void setUser(ArrayList<User> user) {
        this.user = user;
    }

    public Media searchMedia(String title) throws NoSuchElementException{
        for (Media m : media){
            if (m.getTitle().equals(title))
                return m;
        }
        throw new NoSuchElementException();
    }

    public void addUser(User user){
        this.user.add(user);
    }
    public void displayUsers(){
        System.out.println(user);
    }
    public void addMedia(Media media){
        this.media.add(media);
    }
    public void displayMedia(){
        System.out.println(media);
    }
    public Book searchBook(String title) throws NoSuchElementException{
        for (Media m : media){
            if (m.getTitle().equals(title)){
                return (Book) m;
            }
        }
            throw new NoSuchElementException("it doesn't exist");
    }
}
