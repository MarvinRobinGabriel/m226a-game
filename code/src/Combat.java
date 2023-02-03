import java.awt.Color;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Combat {

    public static void fightEncounter(Player p, Monster m) {

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean valid = false;

        String playerHP = " (" + p.health + " HP)";
        String monsterHP = " (" + m.health + " HP)";

        GameEngine.printEmptyLine();
        System.out.println(GameEngine.colorBlue + p.firstname + " " + p.lastname + playerHP + " is being attacked by a " + m.type + monsterHP + GameEngine.colorReset);
        GameEngine.printEmptyLine();

        while( !valid ) {
            GameEngine.printMessage("blue", "How will you respond to this threat?");
            GameEngine.printMessage("red", "1) Agressive Approach");
            GameEngine.printMessage("green", "2) Defensive Approach");

            try {
                choice = sc.nextInt();
                if(choice == 1 || choice == 2){
                   valid = true;
                } else {
                    GameEngine.printMessage("red", "ERROR: Please choose from the provided approaches");
                }
             } catch (InputMismatchException e) {
                GameEngine.printMessage("red", "ERROR: Only numbers permitted.");
                sc.next();
             } 
        }

        if ( valid ) {

            GameEngine.printEmptyLine();

            // print chosen approach
            switch (choice) {
                case 1:
                    fightSimulation(p, m, 1);
                    break;
                case 2:
                    fightSimulation(p, m, 2);
                    break;
            }
        }
    }

    public static void fightSimulation(Player p, Monster m, int approach) {

        int playerHP = p.health;
        int monsterHP = m.health;

        while (monsterHP > 0 && playerHP > 0) {

            int min = 10;
            int max = 25;

            Boolean success = Math.random() < 0.5;
            int playerDMG = (int) Math.floor(Math.random() * (max - min + 1)) + min;
            int monsterDMG = (int) (Math.floor(Math.random() * (max - min + 1)) + min);

            if(success) {

                monsterHP = monsterHP - playerDMG;

                System.out.println(GameEngine.colorGreen + "Success");
                System.out.println(GameEngine.colorBlue + "You have " + playerHP + " HP left." + GameEngine.colorReset);
                System.out.println(GameEngine.colorBlue + "The monster has " + monsterHP + " HP left." + GameEngine.colorReset);
                GameEngine.printEmptyLine();
            } else if (!success) {
                playerHP = playerHP - monsterDMG;

                System.out.println(GameEngine.colorRed + "Failure");
                System.out.println(GameEngine.colorBlue + "You have " + playerHP + " HP left." + GameEngine.colorReset);
                System.out.println(GameEngine.colorBlue + "The monster has " + monsterHP + " HP left." + GameEngine.colorReset);
                GameEngine.printEmptyLine();
            }
        }

        if (playerHP < 0) {
            GameEngine.GameOver();
        }

        if (monsterHP < 0) {
            Location.killMonster(m.id);
        }
    }
}