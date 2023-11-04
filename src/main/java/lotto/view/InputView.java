package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;
import lotto.validator.InputValidator;

public class InputView {
    public String readMoneyToBuyLotto() {
        String input = Console.readLine();
        return input;
    }
}
