package lotto.view;

import lotto.constant.ErrorMessage;

public class OutputView {

    public void printErrorMessage(String message) {
        System.out.println(ErrorMessage.format(message));
    }
}
