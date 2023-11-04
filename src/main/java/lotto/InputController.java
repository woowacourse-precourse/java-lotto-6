package lotto;

public class InputController {

    private final InputView inputView;

    public InputController(InputView inputView) {
        this.inputView = inputView;
    }

    public PurchaseAmount getPurchaseAmount() {
        String purchaseAmountInput = inputView.getPurchaseAmountInput();
        int purchaseAmountValue = Util.stringToInteger(purchaseAmountInput);
        return PurchaseAmount.from(purchaseAmountValue);
    }
}