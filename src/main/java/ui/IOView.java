package ui;

public class IOView {
    private IOView() {
    }

    public static int getMoney() {
        OutputView.sayMoney();
        return InputView.getMoney();
    }
}
