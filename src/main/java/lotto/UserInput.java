package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

public class UserInput {

    private final InputValidator inputValidator;

    UserInput(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public int receiveMoney() {
        String money = Console.readLine();
        inputValidator.validateHasOnlyInteger(money);
        return Integer.parseInt(money);
    }

    public String receiveWinningNumbers() {
        return Console.readLine();
    }


}
