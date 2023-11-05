package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.parser.Parser;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.view.constants.PrintMessage.REQUEST_JACKPOT_NUMBER;

public class JackpotController {
    private JackpotController() {
    }

    public static Lotto requestJackpotNumbers() {
        OutputView.printMessage(REQUEST_JACKPOT_NUMBER);

        return readJackpotNumbers();
    }

    private static Lotto readJackpotNumbers() {
        try {
            final String jackpotNumbers = InputView.readLine();
            List<Integer> numbers = Parser.splitByDelimiter(jackpotNumbers);

            return new Lotto(numbers);
        } catch (LottoException exception) {
            OutputView.println(exception.getMessage());
            return readJackpotNumbers();
        }
    }
}
