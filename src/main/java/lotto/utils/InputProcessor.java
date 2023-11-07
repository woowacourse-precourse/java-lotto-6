package lotto.utils;

import java.util.ArrayList;
import java.util.List;
import lotto.view.InputView;

public class InputProcessor {
    private final static String DELIMITER = ",";
    private final InputView inputView;

    public InputProcessor(InputView inputView) {
        this.inputView = inputView;
    }

    public int getUserInputPurchaseAmount() {
        String input = inputView.inputPurchaseAmount();
        Validation.validateStringToInteger(input);
        return Utils.stringToInteger(input);
    }
    public int getUserInputBonusNumber() {
        String input = inputView.inputBonusNumber();
        Validation.validateStringToInteger(input);
        return Utils.stringToInteger(input);
    }

    public List<Integer> getUserInputWinningNumbers() {
        return getUserInputWinningNumbers(inputView.inputWinningNumbers());
    }
    public List<Integer> getUserInputWinningNumbers(String userInput) {
        List<Integer> winningNumbers = new ArrayList<>();

        String[] numberStrings = userInput.split(DELIMITER);
        for (String numberString : numberStrings) {
            int number = Integer.parseInt(numberString.trim());
            winningNumbers.add(number);
        }

        return winningNumbers;
    }
}
