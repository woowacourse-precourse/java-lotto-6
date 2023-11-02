package lotto.view;

public interface InputView {
    static ConsoleInputView createConsoleInputView() {
        return new ConsoleInputView();
    }

    public String requestPurchaseMoney();
}
