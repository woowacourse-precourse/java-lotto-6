package lotto.view;

import lotto.domain.Amount;

public class View {
    private final InputView inputView;
    private final OutputView outputView;

    public View(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public Amount getAmount() {
        try {
            outputView.printPurchaseGuideMessage();
            String amountValue = inputView.inputAmount();
            return new Amount(Integer.parseInt(amountValue));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getAmount();
        }
    }
}
