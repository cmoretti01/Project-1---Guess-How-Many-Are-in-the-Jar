import java.util.Scanner;

public class Prompter {
    private Jar mJar;
    private Scanner scanner = new Scanner(System.in);
    private String itemInput;
    private int amount;
    private int guess;
    private int attempts;
    private boolean playAgain;

    // Initial prompting to insert the item and fill the jar
    public void promptForItemAndAmount () {
        System.out.printf("Guess How Many Are in the Jar - Welcome to the game!!\n");
        System.out.printf("-----------------------------------------------------\n");
        System.out.printf("What type item should be put in the jar? ");
        itemInput = scanner.nextLine();
        System.out.printf("What is the maximum amount of %s? ");
        amount = scanner.nextInt();
    }
    // Call to play the game
    public void playGame() {
        boolean isGuessValid = false;
        boolean playAgain = false;
        do {
            mJar = new Jar(itemInput, amount);
            mJar.fillJar(amount);
            System.out.printf("**************************\n");
            System.out.printf("How many %s are in the jar? Pick a number between 1 and %d",
                    mJar.getItem(), mJar.getAmount());
            guess = scanner.nextInt();
            while(guess > mJar.getMaxAmount()) {
                System.out.printf("\nOps!!! The guess is larger than the maximum amount of %s.", mJar.getItem());
                System.out.printf("\nPlease, give another guess: ");
                guess = scanner.nextInt();
            } if(guess != mJar.getAmount()) {
                attempts++;
                System.out.printf("Try again! ");
                if(guess > mJar.getAmount()) {
                    System.out.printf("Your Guess is too high\n");
                    System.out.printf("**************************\n");
                } else {
                    System.out.printf("Your guess is too low\n");
                    System.out.printf("**************************\n");
                }
            } else {
                isGuessValid = true;
            }
        } while(!isGuessValid);
        System.out.printf("\nCongrats! You got it in %d attempt(s)!", attempts);
    }
    // Checks if the player wants to play again
    public boolean playAgain() {
        String play = "";

        System.out.printf("\n**************************\n");
        System.out.printf("Let's play again? Type 'y' for continue or 'n' to exit: ");
        play = scanner.nextLine();
        if(play.toLowerCase().charAt(0) == 'y'){
            playAgain = true;
        }
        return playAgain;
    }

    public boolean isPlayAgain() {
        return playAgain;
    }
}