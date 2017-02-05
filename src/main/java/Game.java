public class Game {
    public static void main(String[] args) {
        Prompter prompter = new Prompter();
        do {
            prompter.promptForItemAndAmount();
            prompter.playGame();
        } while(prompter.isPlayAgain());

    }
}
