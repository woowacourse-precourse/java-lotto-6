package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputValidator;

public class InputView {
    InputValidator validator = new InputValidator();

    public int inputMoney() {
        String inputtedMoney = Console.readLine().trim();
        return validator.parseValidatedInt(inputtedMoney);
    }
}
