package lotto.view;

public class View {
    private InputView inputView;
    private OutputView outputView;

    public View() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public InputView getInputView() {
        return inputView;
    }

    public OutputView getOutputView() {
        return outputView;
    }
}
