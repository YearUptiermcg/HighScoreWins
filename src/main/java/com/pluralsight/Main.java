import java.util.Scanner;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String userScores = PromptForString("Please enter a game score: ");
        int indexOfBar = userScores.indexOf("|");
        String afterBar = userScores.substring(indexOfBar + 1);
        String[] scores = afterBar.split(Pattern.quote(":"));
        int leftScore = Integer.parseInt(scores[0]);
        int rightScore = Integer.parseInt(scores[1]);
        boolean isLeftWinner = (leftScore > rightScore);
        String teamnamesString = userScores.substring(0, indexOfBar);
        String[] teamnames = teamnamesString.split(Pattern.quote(":"));

        if (isLeftWinner) {
            System.out.println(teamnames[0] + " Wins!");
        } else {
            boolean isRightWinner = (rightScore > leftScore);
            if (isRightWinner) {
                System.out.println(teamnames[1] + " Wins!");
            }
        }

        System.out.println(userScores);
        System.out.println(indexOfBar);
        System.out.println(afterBar);
        System.out.println(Arrays.toString(scores));
        System.out.println(leftScore);
        System.out.println(rightScore);
    }

    public static String PromptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}
