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

    public void changeLocation(int id) {

    }

    public void attack(Monster m) {

    }

    public void defend(Monster m) {
        
    }

    public void death(Monster m) {
        
        String fullname = firstname + lastname;

        System.out.println(" ");
        System.out.println("GAME OVER: " + fullname + " has been killed by a " + m.type + "!");
        System.out.println(" ");
    }
}
