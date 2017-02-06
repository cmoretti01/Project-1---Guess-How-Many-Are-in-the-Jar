import java.util.Scanner;

public class Prompter {
    private Jar mJar;
    private Scanner scanner = new Scanner(System.in);
    private String itemInput;
    private int amount;
    private int guess;
    private int attempts;

    // Initial prompting to insert the item and fill the jar
    public void playGame() {
        boolean isGuessValid = false;

        System.out.printf("Guess How Many Are in the Jar - Welcome to the game!!\n");
        System.out.printf("-----------------------------------------------------\n");
        System.out.printf("What type item should be put in the jar? ");
        itemInput = scanner.nextLine();
        System.out.printf("What is the maximum amount of %s? ", itemInput);
        amount = scanner.nextInt();

        mJar = new Jar(itemInput, amount);
        mJar.fillJar(amount);

        do {
            do {
                System.out.printf("**************************\n");
                System.out.printf("How many %s are in the jar? Pick a number between 1 and %d: ",
                        mJar.getItem(), mJar.getMaxAmount());
                guess = scanner.nextInt();
                if (guess > mJar.getMaxAmount()) {
                    System.out.printf("\nOps!!! The guess is larger than the maximum amount of %s.", mJar.getItem());
                    System.out.printf("Please, give another guess.\n ");
                }
            }while (guess > mJar.getAmount()) ;
                attempts++;
                if (guess != mJar.getAmount()) {
                    System.out.printf("Try again! ");
                    if (guess > mJar.getAmount()) {
                        System.out.printf("Your Guess is too high!\n");
                    } else {
                        System.out.printf("Your guess is too low!\n");
                    }
                } else {
                    isGuessValid = true;
                }
            } while (!isGuessValid);
        System.out.printf("\nCongrats! You got it in %d attempt(s)!", attempts);
    }
}