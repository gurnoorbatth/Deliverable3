
import java.util.Scanner;

/**
 * This is the Main Class for Game.
 *
 * @author sukhb
 */
public class main {

    public static void main(String[] args) {

        int num_of_suits = 4;
        int num_of_ranks = 13;
        int num_of_players;
        Scanner input = new Scanner(System.in);
        System.out.println("This Game Can be only Played Between 2 or 4 Players");
        System.out.println("Please Enter the Number Of Players");
        num_of_players = input.nextInt();
        if (checkInput(num_of_players)) {
            System.out.println("There are : " + num_of_suits + " Suits," + num_of_ranks + " Ranks, and " + num_of_players + " Players.");
            Game game = new Game(true);
            game.play(num_of_suits, num_of_ranks, num_of_players);
        } else {
            System.out.println("Please Enter The Valid Number of Players");
        }

    }

    public static boolean checkInput(int num_of_players) {
        if (num_of_players == 4 || num_of_players == 2); else {
            return false;
        }
        return true;
    }
}
