package lotto;

import lotto.error.exception.InvalidStateException;
import lotto.ui.ConsoleUI;

public class Application {
    public static void main(String[] args) {
        try {
            new ConsoleUI().play();
        } catch (InvalidStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
