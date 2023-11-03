package lotto.view;

import lotto.utils.message.Message;

public class OutputView {
    public void printLottoCount(int count) {
        System.out.printf(Message.OUTPUT_LOTTO_COUNT, count);
    }
}
