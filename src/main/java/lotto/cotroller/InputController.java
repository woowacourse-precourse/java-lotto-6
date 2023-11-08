package lotto.cotroller;

import java.util.Arrays;
import java.util.List;
import lotto.Util;
import lotto.Validator;
import lotto.view.InputView;

public class InputController {

    private final InputView inputView;

    public InputController(InputView inputView) {
        this.inputView = inputView;
    }

    public int getPurchaseAmount() {
        String purchaseAmountInput = inputView.getPurchaseAmountInput();
        return Integer.parseInt(purchaseAmountInput);
    }

    public List<Integer> getWinningNumber() {
        String winningNumberInput = inputView.getWinningNumberInput();
        String removeSpace = Util.removeSpace(winningNumberInput);
        String[] winningNumberArray = Util.splitByComma(removeSpace);

        validateEachNumberIsInteger(winningNumberArray);

        return Arrays.stream(winningNumberArray)
                .map(Integer::parseInt)
                .toList();
    }

    private void validateEachNumberIsInteger(String[] winningNumberArray) {
        Arrays.stream(winningNumberArray)
                .forEach(Validator::validateIsInteger);
    }

    public int getBonusNumber() {
        String bonusNumberInput = inputView.getBonusNumberInput();
        return Integer.parseInt(bonusNumberInput);
    }
}