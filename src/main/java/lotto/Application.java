package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoGameController;
import lotto.view.input.reader.ConsoleReader;
import lotto.view.output.writer.ConsoleWriter;

public class Application {
    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReader();
        ConsoleWriter consoleWriter = new ConsoleWriter();
        LottoGameController lottoGameController = new LottoGameController(
                consoleReader,
                consoleWriter
        );
        lottoGameController.start();
        Console.close();
    }
}
