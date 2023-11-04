package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;
import lotto.validator.InputValidator;

public class InputView {
    private final InputValidator validator = new InputValidator();

    public Money readMoneyToBuyLotto() {
        String input = Console.readLine();
        validator.validateIsDigit(input);
        return new Money(Integer.parseInt(input));
    }
}
