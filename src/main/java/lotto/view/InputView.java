package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.AmountValidator;

public class InputView {

    public String inputAmount() {
        String amount = Console.readLine();
        AmountValidator.validateAmount(amount);
        return amount;
    }
}
