package lotto.utils;

import java.util.ArrayList;
import java.util.List;
import lotto.view.InputView;

public class InputProcessor {
    private final InputView inputView;

    public InputProcessor(InputView inputView) {
        this.inputView = inputView;
    }

    public List<Integer> getUserInputWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        String userInput = inputView.inputWinningNumbers();

        String[] numberStrings = userInput.split(",");
        for (String numberString : numberStrings) {
            int number = Integer.parseInt(numberString.trim());
            winningNumbers.add(number);
        }

        return winningNumbers;
    }

    public int getUserInputBonusNumber() {
        String userInput = inputView.inputBonusNumber();
        return Integer.parseInt(userInput.trim());
    }

    public int getUserInputPurchaseAmount() {
        String userInput = inputView.inputPurchaseAmount();
        return Integer.parseInt(userInput.trim());
    }
}
