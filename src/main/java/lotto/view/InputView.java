package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;
import lotto.validator.InputValidator;

public class InputView {
    public Money readMoneyToBuyLotto() {
        String input = Console.readLine();
        return new Money(Integer.parseInt(input));
    }
}
