package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class OutputView {

    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    public void printLottoMoney(int lottoAmount) {
        System.out.println(String.format(Message.OUTPUT_LOTTO_MONEY.message, lottoAmount));
    }

    private enum Message {
        OUTPUT_LOTTO_MONEY("%d개를 구매했습니다.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}