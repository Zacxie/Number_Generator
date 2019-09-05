import java.util.Scanner;

public class Main {

    private Scanner scan = new Scanner(System.in);
    private int guess = 1;
    private int start;
    private int end;
    private int chosen;
    private int score = 1;
    private int bestScore=100;

    public static void main(String[] args) {
        Main main = new Main();

        main.start();
    }

    private void start() {
        System.out.println("Please enter start nummber: ");
        try {
            start = Integer.parseInt(scan.nextLine());
            end();
        } catch (NumberFormatException e) {
            System.out.println("Only numbers allowed.");
            start();
        }
    }

    private void end() {
        System.out.println("Enter end number: ");
        try {
            end = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Only numbers allowed.");
            end();
        }
        if (end < start) {
            System.out.println("Start number must be bigger than end number! Have another go");
            end();
        } else {
        }
        generator();
    }

    private void generator() {
        chosen = (int) (Math.random() * (end - start + 1) + start);
        guess();
    }

    private void guess() {
        System.out.println("Make a guess!");
        try {
            guess = Integer.parseInt(scan.nextLine());
            compare();
        } catch (NumberFormatException e) {
            System.out.println("Only numbers allowed.");
            guess();
        }
    }

    private void compare() {
        if (guess == chosen) {
            System.out.println("You guessed it!");
            if (score < bestScore) {
                bestScore = score;
            }
            if (score > 1) {
                System.out.println("You did it in " + score + " tries.");
            } else if (score == 1) {
                System.out.println("You did it in " + score + " try! Lucky shitter!");
            }
            System.out.println("Your best score is " + bestScore + " tries.");
            System.out.println("\n");
            restart();
        } else if (guess < chosen) {
            System.out.println("Too low. Guess higher");
            score++;
            guess();
        } else if (guess > chosen) {
            System.out.println("Too high. Guess lower");
            score++;
            guess();
        }
    }

    private void restart() {
        System.out.println("Do you want to go again? Y for yes, N for no.");
        String goAgain = scan.nextLine();
        System.out.println(goAgain);

        if (goAgain.matches("Y") || goAgain.matches("y")) {
            System.out.println("\n");
            score=1;
            start();
        } else if (goAgain.matches("N") || goAgain.matches("n")) {

        } else {
            restart();
        }
    }
}
