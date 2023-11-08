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

    public void printLotteryNumbers() {
        System.out.println();
        System.out.println(Message.OUTPUT_LOTTERY_NUMBERS.getMessage());
    }

    public void printBonusNumber() {
        System.out.println();
        System.out.println(Message.OUTPUT_BONUS_NUMBERS.getMessage());
    }

    enum Message {
        OUTPUT_PURCHASE_AMOUNT("구입금액을 입력해주세요."),
        OUTPUT_LOTTO_COUNT("%d개를 구매했습니다."),
        OUTPUT_LOTTERY_NUMBERS("당첨 번호를 입력해 주세요."),
        OUTPUT_BONUS_NUMBERS("보너스 번호를 입력해 주세요.");
        private final String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}