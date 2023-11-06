package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoAmount;

public class OutputView {

    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    public void printLottoAmount(LottoAmount lottoAmount) {
        System.out.println(String.format(Message.OUTPUT_LOTTO_AMOUNT.message, lottoAmount.getLottoAmount()));
    }

    private enum Message {
        OUTPUT_LOTTO_AMOUNT("%d개를 구매했습니다.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}