package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.InputValidator;

public class InputView {
    private InputValidator validator;

    public InputView(InputValidator validator) {
        this.validator = validator;
    }

    public int readPurchaseMoney() {
        String input = Console.readLine();
        // validator.checkCanParseInt(input);
        // validator.checkIsNotBlank(input);
        return Integer.parseInt(input);
    }
}
