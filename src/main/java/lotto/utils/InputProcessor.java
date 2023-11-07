package lotto.utils;

import java.util.ArrayList;
import java.util.List;
import lotto.view.InputView;

public class InputProcessor {

    private final InputView inputView;

    public InputProcessor(InputView inputView) {
        this.inputView = inputView;
    }

    public int getUserInputPurchaseAmount() {
        String input = inputView.inputPurchaseAmount();
        Validation.validateStringToInteger(input);
        return parseUserInput(input);
    }
    public int getUserInputBonusNumber() {
        String input = inputView.inputBonusNumber();
        Validation.validateStringToInteger(input);
        return parseUserInput(input);
    }

    public List<Integer> getUserInputWinningNumbers() {
        return getUserInputWinningNumbers(inputView.inputWinningNumbers());
    }
    public List<Integer> getUserInputWinningNumbers(String userInput) {
        List<Integer> winningNumbers = new ArrayList<>();

        String[] numberStrings = userInput.split(",");
        for (String numberString : numberStrings) {
            int number = Integer.parseInt(numberString.trim());
            winningNumbers.add(number);
        }

        return winningNumbers;
    }

    public int parseUserInput(String userInput) {
        return Integer.parseInt(userInput.trim());
    }
}
