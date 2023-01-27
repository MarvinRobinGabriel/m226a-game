import java.util.ArrayList;

public class Location {
    
    int id;
    int exits;
    String title;
    Boolean completed;
    ArrayList<Monster> monsters = new ArrayList<Monster>();

    public Location() {
        id = 0;
        exits = 0;
        title = " ";
        completed = false;
    }

    public void spawnMonster(String type, int health, int damage) {

        Monster m;
        m = new Monster();
        
        m.type = type;
        m.health = health;
        m.damage = damage;

    }

}
