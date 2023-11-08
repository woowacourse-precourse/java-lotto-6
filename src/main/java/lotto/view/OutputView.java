package lotto.view;

import lotto.global.constant.message.LottoMessage;

public class OutputView {

    public void println(String text) {
        System.out.println(text);
    }

    public void printMessage(LottoMessage message) {
        System.out.println(message.getText());
    }

    public void printErrorMessage(Exception error) {
        println(error.getMessage());
    }
}
