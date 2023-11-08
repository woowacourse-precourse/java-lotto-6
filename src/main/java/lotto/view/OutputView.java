package lotto.view;

import java.util.List;

public class OutputView {

    private static final OutputView instance = new OutputView();

    private OutputView() {

    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printPurchaseAmount() {
        System.out.println(Message.OUTPUT_PURCHASE_AMOUNT.getMessage());
    }

    public void printLottoCount(int count) {
        System.out.println(String.format(Message.OUTPUT_LOTTO_COUNT.getMessage(), count));
    }

    public void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    enum Message {
        OUTPUT_PURCHASE_AMOUNT("구입금액을 입력해주세요."),
        OUTPUT_LOTTO_COUNT("%d개를 구매했습니다.");
        private final String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}