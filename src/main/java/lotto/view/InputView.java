package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.ValidationUtils;

public class InputView {
    public long readPurchaseAmount() {
        String userInput = Console.readLine();
        return ValidationUtils.validateLong(userInput);
    }

    public String readInputFromUser() {
        return Console.readLine();
    }
}
