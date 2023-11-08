package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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
        System.out.println();
        System.out.println(String.format(Message.OUTPUT_LOTTO_COUNT.getMessage(), count));
    }

    public void printLottoNumbers(List<Integer> numbers) {
        List<Integer> temp = new ArrayList<>(numbers);
        Collections.sort(temp);
        System.out.println(temp);
    }

    public void printLotteryNumbers() {
        System.out.println();
        System.out.println(Message.OUTPUT_LOTTERY_NUMBERS.getMessage());
    }

    public void printBonusNumber() {
        System.out.println();
        System.out.println(Message.OUTPUT_BONUS_NUMBERS.getMessage());
    }

    public void printResult(Map<Integer, Integer> result, int bonusNumber, int purchaseNumber) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(String.format(Message.OUTPUT_RESULT_3.getMessage(), result.getOrDefault(3, 0)));
        System.out.println(String.format(Message.OUTPUT_RESULT_4.getMessage(), result.getOrDefault(4, 0)));
        System.out.println(String.format(Message.OUTPUT_RESULT_5.getMessage(), result.getOrDefault(5, 0)));
        System.out.println(
                String.format(Message.OUTPUT_BONUS_RESULT_5.getMessage(), result.getOrDefault(bonusNumber, 0)));
        System.out.println(String.format(Message.OUTPUT_RESULT_6.getMessage(), result.getOrDefault(6, 0)));

        long sum = result.getOrDefault(3, 0) * 5000 + result.getOrDefault(4, 0) * 50000
                + result.getOrDefault(5, 0) * 1500000 + result.getOrDefault(6, 0) * 2000000000
                + result.getOrDefault(bonusNumber, 0) * 30000000;
        System.out.print("총 수익률은 " + String.format("%.1f", (sum * 100.0 / purchaseNumber)) + "%입니다.");
    }

    enum Message {
        OUTPUT_PURCHASE_AMOUNT("구입금액을 입력해주세요."),
        OUTPUT_LOTTO_COUNT("%d개를 구매했습니다."),
        OUTPUT_LOTTERY_NUMBERS("당첨 번호를 입력해 주세요."),
        OUTPUT_BONUS_NUMBERS("보너스 번호를 입력해 주세요."),
        OUTPUT_RESULT_3("3개 일치 (5,000원) - %d개"),
        OUTPUT_RESULT_4("4개 일치 (50,000원) - %d개"),
        OUTPUT_RESULT_5("5개 일치 (1,500,000원) - %d개"),
        OUTPUT_BONUS_RESULT_5("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
        OUTPUT_RESULT_6("6개 일치 (2,000,000,000원) - %d개");
        private final String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}