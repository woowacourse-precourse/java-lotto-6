package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputValidator;

import java.util.List;

public class InputView {
    InputValidator validator = new InputValidator();

    public int inputMoney() {
        String inputtedMoney = Console.readLine().trim();
        return validator.parseValidatedInt(inputtedMoney);
    }

    public List<Integer> inputNumbers() {
        String inputtedNumbers = Console.readLine().trim();
        return validator.parseValidatedNumbers(inputtedNumbers);
    }

    public int inputBonusNumber() {
        String inputtedBonusNumber = Console.readLine().trim();
        return validator.parseValidatedInt(inputtedBonusNumber);
    }
}
