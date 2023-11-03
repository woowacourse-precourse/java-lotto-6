package lotto.view;

public interface InputView {
    static ConsoleInputView createConsoleInputView() {
        return new ConsoleInputView();
    }

    public String requestPurchaseMoney();
    public String requestWinningNumber();
    public String requestBonusNumber();
}
