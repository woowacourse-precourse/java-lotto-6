package lotto.view;

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

    enum Message {
        OUTPUT_PURCHASE_AMOUNT("구입금액을 입력해주세요.");

        private final String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}