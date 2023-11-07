package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.validator.InputValidator;

import java.util.Arrays;

public class InputView {
    private final InputValidator validator = new InputValidator();

    public Money readMoneyToBuyLotto() {
        String input = Console.readLine();
        validator.validateIsDigit(input);
        return new Money(Integer.parseInt(input));
    }

    public WinningNumbers readWinningNumbers() {
        String input = Console.readLine();
        validator.validateIsSplitByComma(input);
        return new WinningNumbers(
                Arrays.stream(input.split(","))
                        .map(Integer::parseInt).toList()
        );
    }

    public BonusNumber readBonusNumber() {
        String input = Console.readLine();
        validator.validateIsDigit(input);
        return new BonusNumber(Integer.parseInt(input));
    }
}
