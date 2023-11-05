package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;
import lotto.validator.MoneyValidator;
import lotto.validator.Validator;

public class InputView {

    private final InputValidator inputValidator = new InputValidator();
    private final MoneyValidator moneyValidator = new MoneyValidator();
    public int readPurchaseAmount() {
        String input = Console.readLine();
        inputValidator.validate(input);
        moneyValidator.validate(input);
        return Integer.parseInt(input);
    }


}
