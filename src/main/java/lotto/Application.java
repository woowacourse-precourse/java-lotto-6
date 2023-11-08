package lotto;

import lotto.controller.LottoGameController;
import lotto.model.NumberGenerator;
import lotto.model.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.printer.ConsolePrinter;
import lotto.view.printer.Printer;
import lotto.view.reader.ConsoleReader;
import lotto.view.reader.Reader;

public class Application {
    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Printer printer = new ConsolePrinter();
        InputView inputView = InputView.of(reader, printer);
        OutputView outputView = OutputView.from(printer);

        NumberGenerator numberGenerator = new RandomNumberGenerator();
        LottoGameController lottoGameController = new LottoGameController(inputView, outputView, numberGenerator);
        lottoGameController.run();
    }
}
