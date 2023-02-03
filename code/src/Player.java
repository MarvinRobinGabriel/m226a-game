public class Player {
    
    int id;
    String firstname;
    String lastname;
    int health;
    int damage;

    public Player() {
        id = 0;
        firstname = "";
        lastname = "";
        health = 0;
        damage = 0;
    }

    public void setHealth(int hp) {
        health = hp;
    }

}
