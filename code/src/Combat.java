import java.awt.Color;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Combat {

    // player gets attacked by monster(s) and is confronted with a choice of actions
    public static void fightEncounter(Player p, Monster m) {

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean valid = false;

        // simply used to style health
        String playerHP = " (" + p.health + " HP)"; 
        String monsterHP = " (" + m.health + " HP)";

        GameEngine.printEmptyLine();
        System.out.println(GameEngine.textBold + GameEngine.colorBlue + p.firstname + " " + p.lastname + playerHP + GameEngine.colorReset + " is being attacked by a " + GameEngine.colorBlue + m.type + monsterHP + GameEngine.colorReset + GameEngine.textPlain);

        while( !valid ) {
            GameEngine.printMessage("bold", "blue", "How will you respond to this threat?");
            GameEngine.printMessage("plain", "default", "1) Agressive Approach");
            GameEngine.printMessage("plain", "default", "2) Defensive Approach");

            try {
                choice = sc.nextInt();
                if(choice == 1 || choice == 2){
                   valid = true;
                } else {
                    GameEngine.printMessage("plain","red", "ERROR: Please choose from the provided approaches");
                }
             } catch (InputMismatchException e) {
                GameEngine.printMessage("plain","red", "Only numbers permitted.");
                sc.next();
             } 
        }

        if ( valid ) {

            GameEngine.printEmptyLine();

            // print chosen approach
            switch (choice) {
                case 1:
                    fightSimulation(p, m, 1); // simulate fight with an attacking mindset
                    break;
                case 2:
                    fightSimulation(p, m, 2); // simulate fight with a defensive mindset
                    break;
            }
        }
    }

    // simulate the fight between plaer and monster
    public static void fightSimulation(Player p, Monster m, int approach) {

        int playerHP = p.health;
        int monsterHP = m.health;

        while (monsterHP > 0 && playerHP > 0) {

            // min-max used for random damage values
            int min = 10;
            int max = 25;

            Boolean success = Math.random() < 0.5; // randomly determine who wints maneuver
            int playerDMG = (int) Math.floor(Math.random() * (max - min + 1)) + min; // randomly determine player damage for each maneuver
            int monsterDMG = (int) (Math.floor(Math.random() * (max - min + 1)) + min); // randomly determine monster damage for each maneuver

            // used when player got the better of monster
            if (success) {
                monsterHP = monsterHP - playerDMG;
                System.out.println(GameEngine.colorGreen + "Maneuver was successful" + GameEngine.colorReset );
                System.out.println("You have " + playerHP + " HP left.");
                System.out.println("The monster has " + monsterHP + " HP left.");
            } 
            
            // used when player got the better of monster
            else if (!success) {
                playerHP = playerHP - monsterDMG;

                System.out.println(GameEngine.colorRed + "Maneuver has failed" + GameEngine.colorReset);
                System.out.println( "You have " + playerHP + " HP left.");
                System.out.println( "The monster has " + monsterHP + " HP left.");
            }
        }

        // handle fight outcome
        if (playerHP < 0) {
            GameEngine.GameOver(m.type, monsterHP);
        }
        if (monsterHP < 0) {
            Location.killMonster(m.id);
        }
    }
}
