package lotto.view;

import lotto.common.util.OutputMessage;

public class OutputView {

    public void outputStartMessage() {
        printlnOut(OutputMessage.START
                .getMessage());
    }

    private void printlnOut(String message) {
        System.out.println(message);
    }

}
