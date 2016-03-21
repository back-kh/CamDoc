package m1.gic.camdoc;

/**
 * Created by THUON Nimol on 3/21/2016.
 */
public class User {

    String email, username, password;


    public User(String email, int age, String username, String password) {
        this.email = email ;
        this.username = username;
        this.password = password;
    }

    public User(String email, String username, String password) {
        this("", -1, username, password);
    }
}
