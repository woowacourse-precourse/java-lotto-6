package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.Validator;

public class InputView {
    public InputInfo inputPurchaseAmount() {
        String userInput = Console.readLine();
        return new InputInfo(Validator.VALIDATOR.getInputValidator().inputPurchaseAmountValidation(userInput),
                userInput);
    }

    public InputInfo inputWinningNumbers() {
        String userInput = Console.readLine();
        List<String> splitedList = splitUserInput(userInput);
        return new InputInfo(Validator.VALIDATOR.getInputValidator().inputWinningNumbersValidation(splitedList),
                userInput);
    }

    public InputInfo inputBonusNumber() {
        String userInput = Console.readLine();
        return new InputInfo(Validator.VALIDATOR.getInputValidator().inputBonusNumberValidation(userInput), userInput);
    }

    public List<String> splitUserInput(String userInput) {
        return Arrays.stream(userInput.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
