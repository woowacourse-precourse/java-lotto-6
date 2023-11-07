package lotto.view;

public class View {

    private View() {

    }

    public Integer readPurchaseAmount() {
        OutputView.printReadPurchaseAmountMessage();
        return InputView.readPurchaseAmount();
    }
}
