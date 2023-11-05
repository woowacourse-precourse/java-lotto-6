package lotto;

import java.util.Arrays;
import java.util.List;

public class InputController {

    private final InputView inputView;

    public InputController(InputView inputView) {
        this.inputView = inputView;
    }

    public PurchaseAmount getPurchaseAmount() {
        String purchaseAmountInput = inputView.getPurchaseAmountInput();
        int purchaseAmountValue = Integer.parseInt(purchaseAmountInput);
        return PurchaseAmount.from(purchaseAmountValue);
    }

    public WinningNumber getWinningNumber() {
        String winningNumberInput = inputView.getWinningNumberInput();
        String removeSpace = Util.removeSpace(winningNumberInput);
        String[] winningNumberArray = Util.splitByComma(removeSpace);

        validateEachNumberIsInteger(winningNumberArray);

        List<Integer> winningNumber = Arrays.stream(winningNumberArray)
                .map(Integer::parseInt)
                .toList();

        return WinningNumber.from(winningNumber);
    }

    private void validateEachNumberIsInteger(String[] winningNumberArray) {
        Arrays.stream(winningNumberArray)
                .forEach(Validator::validateIsInteger);
    }
}