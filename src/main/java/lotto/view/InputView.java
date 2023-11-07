package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.validator.GlobalValidator.validateBlank;
import static lotto.validator.GlobalValidator.validateNumber;
import static lotto.validator.WinningNumbersValidator.validateCommaAtStartOrEnd;

public class InputView {

    public String purchaseCost() {
        String input = Console.readLine();
        validateBlank(input);
        validateNumber(input);
        return input;
    }

    public String lottoWinningNumbers() {
        String input = Console.readLine();
        validateBlank(input);
        validateCommaAtStartOrEnd(input);
        return input;
    }

    public String bonusWinningNumbers() {
        String input = Console.readLine();
        validateBlank(input);
        validateNumber(input);
        return input;
    }
}
