package lotto.view;

import java.util.List;

public class OutputValue {

    private static final String PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_LOTTO_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WIN_STATISTICS_MESSAGE = "당첨 통계";
    private static final String LINE_BREAK = "---";
    private static final String FIFTH_PLACE_MESSAGE = "3개 일치 (5,000원) - %d개";
    private static final String FOURTH_PLACE_MESSAGE = "4개 일치 (50,000원) - %d개";
    private static final String THIRD_PLACE_MESSAGE = "5개 일치 (1,500,000원) - %d개";
    private static final String SECOND_PLACE_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    private static final String FIRST_PLACE_MESSAGE = "6개 일치 (2,000,000,000원) - %d개";
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

    public static void firstPlaceMessage(int count) {
        System.out.println(String.format(FIRST_PLACE_MESSAGE, count));
    }

    public static void secondPlaceMessage(int count) {
        System.out.println(String.format(SECOND_PLACE_MESSAGE, count));
    }

    public static void thirdPlaceMessage(int count) {
        System.out.println(String.format(THIRD_PLACE_MESSAGE, count));
    }

    public static void fourthPlaceMessage(int count) {
        System.out.println(String.format(FOURTH_PLACE_MESSAGE, count));
    }

    public static void fifthPlaceMessage(int count) {
        System.out.println(String.format(FIFTH_PLACE_MESSAGE, count));
    }

    public static void revenueMessage(float revenue) {
        System.out.println(String.format(REVENUE_MESSAGE, revenue));
    }
}
