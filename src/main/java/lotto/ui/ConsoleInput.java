package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.InputValidator;
import lotto.util.SplitNumber;

public class ConsoleInput implements Input {
    private InputValidator inputValidator;

    public ConsoleInput() {
        inputValidator = new InputValidator();
    }

    @Override
    public int getPrice() {
        String inputPrice = Console.readLine();
        inputValidator.validateIsNumber(inputPrice);

        return parseNumber(inputPrice);
    }

    @Override
    public Integer getBonusNumbers() {
        String inputBonusNumber = Console.readLine();
        inputValidator.validateIsNumber(inputBonusNumber);

        return parseNumber(inputBonusNumber);
    }

    private static int parseNumber(String inputPrice) {
        return Integer.parseInt(inputPrice);
    }

    @Override
    public List<Integer> getWinningNumbers() {
        String inputWinningNumbers = Console.readLine();
        List<Integer> winningNumbers = SplitNumber.splitNumber(inputWinningNumbers);

        return winningNumbers;
    }
}
