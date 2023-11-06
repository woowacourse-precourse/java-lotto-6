package lotto.view;

import java.util.List;

public class OutputView {
    private final String LOTTO_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private final String RESULT_TITLE = "당첨 통계";
    private final String DIVIDER = "---";
    private final String FIRST_PRIZE = "6개 일치 (2,000,000,000원) - ";
    private final String SECOND_PRIZE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private final String THIRD_PRIZE = "5개 일치 (1,500,000원) - ";
    private final String FORTH_PRIZE = "4개 일치 (50,000원) - ";
    private final String FIFTH_PRIZE = "3개 일치 (5,000원) - ";
    private final String AMOUNT = "개";
    private final String TOTAL_PROFIT = "총 수익률은 ";
    private final String END = "%입니다.";

    public void printLottoAmount(int amountOfLotto) {
        printEmptyLine();
        System.out.println(amountOfLotto + LOTTO_AMOUNT_MESSAGE);
    }

    public void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void printEmptyLine() {
        System.out.println();
    }

    public void printLottoResult(List<Integer> list) {
        System.out.println(FIFTH_PRIZE + list.get(4) + AMOUNT);
        System.out.println(FORTH_PRIZE + list.get(3) + AMOUNT);
        System.out.println(THIRD_PRIZE + list.get(2) + AMOUNT);
        System.out.println(SECOND_PRIZE + list.get(1) + AMOUNT);
        System.out.println(FIRST_PRIZE + list.get(0) + AMOUNT);
    }

    public void printResultTitle() {
        System.out.println(RESULT_TITLE);
        System.out.println(DIVIDER);
    }

    public void printProfit(int money, int totalPrice) {
        double profit = (totalPrice * 100.0) / money;
        System.out.println(TOTAL_PROFIT + profit + END);
    }
}
