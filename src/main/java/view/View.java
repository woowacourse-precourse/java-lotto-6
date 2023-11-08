package view;

public class View {
    private final InputView inputView;
    private final OutputView outputView;

    public View(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public int requirePurchaseAmount() {
        outputView.requestPurchaseAmount();
        return inputView.enterPurchaseAmount();
    }
}
