package lotto;

import lotto.io.InputHandler;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        String input = inputHandler.askAmount();

        System.out.println(input);
    }
}
