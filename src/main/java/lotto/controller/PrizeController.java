package lotto.controller;

import lotto.domain.lottery.Lotto;
import lotto.domain.parser.Parser;
import lotto.domain.prize.Prize;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.view.constants.PrintMessage.REQUEST_JACKPOT_BONUS_NUMBER;
import static lotto.view.constants.PrintMessage.REQUEST_JACKPOT_NUMBER;

public class PrizeController {
    private PrizeController() {
    }

    public static Prize requestJackpotNumbers() {
        OutputView.printMessage(REQUEST_JACKPOT_NUMBER);
        Lotto prizeNumbers = readJackpotNumbers();

        OutputView.printNewLine();
        OutputView.printMessage(REQUEST_JACKPOT_BONUS_NUMBER);
        return requestBonusNumber(prizeNumbers);
    }

    public static Prize requestBonusNumber(final Lotto prizeNumbers) {
        try {
            final String bonusNumberInput = InputView.readLine();
            return Prize.of(prizeNumbers, bonusNumberInput);
        } catch (LottoException exception) {
            OutputView.println(exception.getMessage());
            return requestBonusNumber(prizeNumbers);
        }
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
