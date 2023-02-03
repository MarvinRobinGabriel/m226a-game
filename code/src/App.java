import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        new App().start();
    }

    public void start() {    
        GameEngine.printSegment("title");
        menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean repeat = true;

        while ( repeat ) {
            GameEngine.printMessage("blue", "Please choose a number to continue");
            GameEngine.printMessage("blue", "1) Start Game");
            GameEngine.printMessage("blue", "2) About this Project:");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    repeat = false;
                    GameEngine.locationFactory();
                    GameEngine.createPlayer();
                    break;
                case 2:
                    repeat = true;
                    GameEngine.printSegment("about");
                    break;
                default:
                    repeat = true;
                    GameEngine.printMessage("red", "Please choose from the provided options");
                    return;
            }
        }
    }
}
