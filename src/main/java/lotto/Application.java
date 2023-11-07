package lotto;

import lotto.controller.LottoGameController;
import lotto.domain.randomnumber.RandomNumberPicker;
import lotto.domain.randomnumber.SystemRandomNumberPicker;
import lotto.view.InputView;
import lotto.view.printer.ConsolePrinter;
import lotto.view.printer.Printer;
import lotto.view.reader.ConsoleReader;
import lotto.view.reader.Reader;
import lotto.view.result.ResultView;
import lotto.view.result.ResultViewFormatter;

public class Application {

    public static void main(String[] args) {
        setUpLottoGameController().run();
    }

    private static LottoGameController setUpLottoGameController() {
        Reader reader = new ConsoleReader();
        Printer printer = new ConsolePrinter();
        InputView inputView = InputView.of(reader, printer);

        ResultViewFormatter formatter = new ResultViewFormatter();
        ResultView resultView = new ResultView(printer, formatter);

        RandomNumberPicker numberPicker = new SystemRandomNumberPicker();

        return new LottoGameController(inputView, resultView, numberPicker);
    }

}
