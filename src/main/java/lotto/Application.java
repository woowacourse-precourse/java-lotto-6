package lotto;

import lotto.controller.Game;
import lotto.ui.ConsoleInputReader;
import lotto.ui.ConsoleOutputWriter;
import lotto.ui.InputReader;
import lotto.ui.OutputWriter;

public class Application {
    public static void main(String[] args) {
        InputReader inputReader = new ConsoleInputReader();
        OutputWriter outputWriter = new ConsoleOutputWriter();

        Game game = new Game(inputReader, outputWriter);
        game.start();

        inputReader.close();
    }
}
