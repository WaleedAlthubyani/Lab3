import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {

        Store s = new Store();

        ArrayList<Review> review = new ArrayList<>();

        Book book1 = new Book("book1","book auteur","2151251251212",22,5,review);
        Book book2 = new Book("book2","book auteur","5125136132412",59,15,review);
        Book book3 = new Book("book3","Book Noop","2512541351241",11,5,review);
        Book book4 = new Book("book4","Book Noop","1251242131234",20,7,review);

        book1.setTitle("Hello");
        book1.setAuteur("World");
        book1.setISBN("3141592653589");
        book1.setPrice(55);
        s.addMedia(book1);
        s.addMedia(book2);
        s.addMedia(book3);
        s.addMedia(book4);

        Movie movie1 = new Movie("A Nightmare on Elm Street","Wes Craven","9781401214579",255.25,91);
        Movie movie2 = new Movie("Interstellar","Christopher Nolan","9788972915751",882.84,169);
        Movie movie3 = new Movie("Oppenheimer","Christopher Nolan","9780571381319",78.22,180);
        Movie movie4 = new Movie("Spider-man: Into the Spider-Verse","Stan lee","9781789090437",133.0,116);

        s.addMedia(movie1);
        s.addMedia(movie2);
        s.addMedia(movie3);
        s.addMedia(movie4);

        Music music1 = new Music("Hail to the King","M.shadows,Synyster Gates","5136135261241",30,"Avenged Sevenfold");
        Music music2 = new Music("Believer","Dan Reynolds","5219481257251",25,"Imagine Dragons");
        Music music3 = new Music("Radioactive","Dan Reynolds","5121626412515",27,"Imagine Dragons");
        Music music4 = new Music("What I've Done","Linkin Park","5125216513124",28,"Linkin Park");

        s.addMedia(music1);
        s.addMedia(music2);
        s.addMedia(music3);
        s.addMedia(music4);


        Novel novel1 = new Novel("novel1","Novel Auteur","1251251361422",225,5,review,"Comedy");
        Novel novel2 = new Novel("Novel2","Novel Auteur","5102512041212",152,2,review,"Action");
        Novel novel3 = new Novel("Novel3","Newbie","1251265131242",92.25,7,review,"Fantasy");
        Novel novel4 = new Novel("Novel4","Newbie","2151212412512",95.82,10,review,"Slice of life");

        s.addMedia(novel1);
        s.addMedia(novel2);
        s.addMedia(novel3);
        s.addMedia(novel4);


        AcademicBook academic1 = new AcademicBook("Java","Oracle","5125215125152",350.24,15,review,"Computer science");
        AcademicBook academic2 = new AcademicBook("History of Saudi Arabia","idk","5125124124121",150,20,review,"History");
        AcademicBook academic3 = new AcademicBook("The Middle East","idk","5215215112352",120,5,review,"Geography");
        AcademicBook academic4 = new AcademicBook("Algebra", "math guy", "2151236321512",195,50,review,"Mathematics");

        s.addMedia(academic1);
        s.addMedia(academic2);
        s.addMedia(academic3);
        s.addMedia(academic4);

        s.displayMedia();
        System.out.println();
        s.displayUsers();
        System.out.println();


        User u1 = new User("Waleed","waleedalthebiany@gmail.com");
        s.addUser(u1);
        s.displayUsers();
        System.out.println();

        for (int i = 0; i < 3; i++) {
            try {
                u1.addToCart(s.searchMedia("Novel2"));
                u1.addToCart(s.searchMedia("What I've Done"));
                u1.addToCart(s.searchMedia("A Nightmare on Elm Street"));
                u1.addToCart(s.searchMedia("Java"));
            } catch (NoSuchElementException e) {
                System.out.println("We don't have it");
            }
        }

        System.out.println("shop cart full");
        s.displayUsers();
        System.out.println();

        u1.checkout();

        System.out.println("After purchase");
        s.displayUsers();


        System.out.println();

        u1.addReview(4.5,"Great book",u1.getPurchaseMediaList().get(3));

        System.out.println();
        s.displayUsers();

        System.out.println();

        System.out.println(academic1.getTitle()+" is a/an "+academic1.getMediaType());

        System.out.println();

        System.out.println(s.getMedia().get(5));
        System.out.println();


        try {
        System.out.println(s.searchBook("book2"));
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        //testing the rest of the methods
        Store s2 = new Store();
        ArrayList<User> user = new ArrayList<>();
        ArrayList<Media> media = new ArrayList<>();
        s2.setUser(user);
        s2.setMedia(media);

        User u2 = new User("someone","someone@somewhere.com");
        u2.setEmail("someone@here.com");
        u2.setUsername("Mohammed");
        u2.setPurchaseMediaList(media);
        u2.setShoppingCart(media);

        ArrayList<Review> rs = new ArrayList<>();
        Review r = new Review(u2.getUsername(),4,"meh");
        r.setComment("blah");
        r.setUsername(u1.getUsername());
        r.setRating(2);
        System.out.println(r);
        book1.setReview(rs);
        book1.restock(55);

        Movie m1 = new Movie("m1","m1","1234124215125",1,1111);
        m1.setDuration(1);

        ArrayList<Movie> all = new ArrayList<>();
        all.add(movie1);
        all.add(movie2);
        all.add(movie3);
        all.add(movie4);
        System.out.println(movie2.recommendSimilarMovies(all));

        ArrayList<Music> allMusic = new ArrayList<>();
        Music m = new Music("m","m","12512124123",215,"m");
        m.setArtist("mm");
        System.out.println(m.generatePlaylist(allMusic));

        novel4.setGenre("Drama");

        academic4.setSubject("Math");

        System.out.println();

        s.displayMedia();

    }
}