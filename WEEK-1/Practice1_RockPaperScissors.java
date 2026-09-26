import java.util.*;

public class Practice1_RockPaperScissors {

    static String playRound(String player, String computer) {

        if (player.equals(computer))
            return "Draw";

        if ((player.equals("Rock") && computer.equals("Scissors")) ||
            (player.equals("Paper") && computer.equals("Rock")) ||
            (player.equals("Scissors") && computer.equals("Paper")))
            return "Player Wins";

        return "Computer Wins";
    }

    public static void main(String[] args) {

        String[] moves = {"Rock", "Paper", "Scissors"};
        Random r = new Random();

        int wins = 0, losses = 0, draws = 0;

        for (int i = 1; i <= 5; i++) {

            String player = moves[r.nextInt(3)];
            String computer = moves[r.nextInt(3)];

            String result = playRound(player, computer);

            System.out.println("Round " + i +
                    " | Player: " + player +
                    " | Computer: " + computer +
                    " | " + result);

            if (result.equals("Player Wins"))
                wins++;
            else if (result.equals("Computer Wins"))
                losses++;
            else
                draws++;
        }

        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win %: " + (wins * 100.0 / 5));
    }
}