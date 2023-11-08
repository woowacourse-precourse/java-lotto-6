package lotto.view;

import java.util.List;

public class OutputValue {

    private static final String PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_LOTTO_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WIN_STATISTICS_MESSAGE = "당첨 통계";
    private static final String LINE_BREAK = "---";
    private static final String WINNING_SECOND_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String WINNING_RESULT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String REVENUE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void purchaseMessage() {
        System.out.println(PURCHASE_PRICE_MESSAGE);
    }

    public static void lottoCountMessage(int lottoCount) {
        System.out.println(lottoCount + LOTTO_COUNT_MESSAGE);
    }

    public static void purchaseLottoMessage(List<Integer> numbers) {
        System.out.println(numbers.toString());
    }

    public static void changeLine() {
        System.out.println();
    }

    public static void winningLottoNumbersMessage() {
        System.out.println(WINNING_LOTTO_NUMBERS_MESSAGE);
    }

    public static void bonusNumberMessage() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public static void winStatisticsMessage() {
        System.out.println(WIN_STATISTICS_MESSAGE);
        System.out.println(LINE_BREAK);
    }

    public static void winningLottoResultMessage(int matchCount, String price, int count) {
        System.out.println(String.format(WINNING_RESULT_MESSAGE, matchCount, price, count));
    }

    public static void winningLottoSecondPrizeMessage (int matchCount, String price, int count) {
        System.out.println(String.format(WINNING_SECOND_MESSAGE, matchCount, price, count));
    }


    public static void revenueMessage(float revenue) {
        System.out.println(String.format(REVENUE_MESSAGE, revenue));
    }
}
