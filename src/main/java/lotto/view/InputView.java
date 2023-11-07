package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.validator.InputValidator;

import java.util.Arrays;

public class InputView {
    private static final String SPLIT_REGEX = ",";
    private final InputValidator validator = new InputValidator();

    public Money inputMoneyToBuyLotto() {
        String input = Console.readLine();
        validator.validateIsDigit(input);
        return new Money(Integer.parseInt(input));
    }

    public WinningNumbers inputWinningNumbers() {
        String input = Console.readLine();
        validator.validateIsSplitByCommaAndDigit(input);
        return new WinningNumbers(
                Arrays.stream(input.split(SPLIT_REGEX))
                        .map(Integer::parseInt).toList()
        );
    }

    public BonusNumber inputBonusNumber() {
        String input = Console.readLine();
        validator.validateIsDigit(input);
        return new BonusNumber(Integer.parseInt(input));
    }
}
