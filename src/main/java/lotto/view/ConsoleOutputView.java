package lotto.view;

import lotto.view.constant.Message;

public class ConsoleOutputView implements OutputView {
    protected ConsoleOutputView() {}

    public void printMessage(Message message) {
        System.out.println(message.getMessage());
    }
}
