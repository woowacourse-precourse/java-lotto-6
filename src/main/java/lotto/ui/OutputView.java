package lotto.ui;

import lotto.ui.message.OutputMessage;

public class OutputView {

    public void print(OutputMessage outputMessage) {
        System.out.println(outputMessage.getComment());
    }

}
