import java.util.ArrayList;

public class Music extends Media{
    private String artist;

    Music(String title,String auteur,String ISBN,double price,String artist){
        super( title, auteur, ISBN, price);
        this.artist=artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void listen(User user){
        user.addPurchaseMediaList(user.getShoppingCart().getFirst());
    }

    public ArrayList<Music> generatePlaylist(ArrayList<Music> musicCatalog){
        ArrayList<Music> playList=new ArrayList<>();

        for (Music m : musicCatalog){
            if (m.getAuteur().equals(getAuteur())){
                playList.add(m);
            }
        }

        return playList;
    }

    @Override
    public String getMediaType() {
        return (getPrice()>=10) ? "Premium Music":"Music";
    }

    @Override
    public String toString() {
        return super.toString() + "\nArtist: "+getArtist();
    }
}
