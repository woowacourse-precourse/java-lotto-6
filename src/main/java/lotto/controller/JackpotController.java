package lotto.controller;

import lotto.domain.lottery.JackpotNumber;
import lotto.domain.parser.Parser;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static lotto.view.constants.PrintMessage.REQUEST_JACKPOT_BONUS_NUMBER;
import static lotto.view.constants.PrintMessage.REQUEST_JACKPOT_NUMBER;

public class JackpotController {
    private JackpotController() {
    }

    public static List<JackpotNumber> requestJackpotNumbers() {
        OutputView.printMessage(REQUEST_JACKPOT_NUMBER);

        return readJackpotNumbers();
    }

    private static List<JackpotNumber> readJackpotNumbers() {
        try {
            final String jackpotNumbers = InputView.readLine();
            List<Integer> numbers = Parser.splitByDelimiter(jackpotNumbers);

            
            return JackpotNumber.createNormalJackpotNumbers(numbers);
        } catch (LottoException exception) {
            OutputView.println(exception.getMessage());
            return readJackpotNumbers();
        }
    }

    public static JackpotNumber requestJackpotBonusNumber() {
        OutputView.printNewLine();
        OutputView.printMessage(REQUEST_JACKPOT_BONUS_NUMBER);

        return readJackpotBonusNumber();
    }

    private static JackpotNumber readJackpotBonusNumber() {
        try {
            final String jackpotNumbers = InputView.readLine();
            int number = Parser.parseStringToInt(jackpotNumbers);

            return JackpotNumber.createBonusJackpotNumber(number);
        } catch (LottoException exception) {
            OutputView.println(exception.getMessage());
            return readJackpotBonusNumber();
        }
    }
}
