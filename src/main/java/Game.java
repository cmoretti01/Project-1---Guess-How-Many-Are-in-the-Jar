public class Game {
    public static void main(String[] args) {
        Prompter prompter = new Prompter();
        do {
            prompter.promptForItemAndAmount();
            prompter.playGame();
            prompter.playAgain();
        } while(prompter.isPlayAgain());

    }
}
