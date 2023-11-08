package lotto.controller;

import lotto.domain.lottery.Lotto;
import lotto.domain.prize.Prize;
import lotto.exception.LottoException;
import lotto.service.Parser;
import lotto.view.input.InputReader;
import lotto.view.output.OutputWriter;

import java.util.List;

import static lotto.view.constants.PrintMessage.REQUEST_BONUS_NUMBER;
import static lotto.view.constants.PrintMessage.REQUEST_PRIZE_NUMBER;

public class PrizeController {
    private PrizeController() {
    }

    public static Prize requestPrizeNumbers() {
        OutputWriter.printMessage(REQUEST_PRIZE_NUMBER);
        Lotto prizeNumbers = readPrizeNumbers();

        OutputWriter.printNewLine();
        OutputWriter.printMessage(REQUEST_BONUS_NUMBER);
        return requestBonusNumber(prizeNumbers);
    }

    public static Prize requestBonusNumber(final Lotto prizeNumbers) {
        try {
            final String bonusNumberInput = InputReader.readLine();
            final int bonusNumber = Parser.parseStringToInt(bonusNumberInput);
            return Prize.of(prizeNumbers, bonusNumber);
        } catch (LottoException exception) {
            OutputWriter.println(exception.getMessage());
            return requestBonusNumber(prizeNumbers);
        }
    }

    private static Lotto readPrizeNumbers() {
        try {
            final String prizeNumbers = InputReader.readLine();
            List<Integer> numbers = Parser.splitByDelimiter(prizeNumbers);

            return new Lotto(numbers);
        } catch (LottoException exception) {
            OutputWriter.println(exception.getMessage());
            return readPrizeNumbers();
        }
    }
}
