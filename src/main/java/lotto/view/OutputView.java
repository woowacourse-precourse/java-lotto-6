package lotto.view;

import lotto.view.constant.Message;

public interface OutputView {
    static ConsoleOutputView createConsoleOutputView() {
        return new ConsoleOutputView();
    }
    public void printMessage(Message message);
}
