package lotto.view;

import lotto.domain.Prize;

import java.util.Map;

public class OutputView {

    private static final String INPUT_BUY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUM_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUM_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String TICKET_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String LOTTO_RESULT_BAR_MESSAGE = "당첨 통계\n---";
    private static final String LOTTO_SECOND_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String LOTTO_RESULT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String TOTAL_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void inputBuyMessage() {
        System.out.println(INPUT_BUY_MESSAGE);
    }

    public static void inputWinningNumMessage() {
        System.out.println(INPUT_WINNING_NUM_MESSAGE);
    }

    public static void inputBonusNumMessage() {
        System.out.println(INPUT_BONUS_NUM_MESSAGE);
    }

    public static void printBlank() {
        System.out.println();
    }

    public static void ticketCountMessage(int ticketCount) {
        System.out.println(ticketCount + TICKET_COUNT_MESSAGE);
    }

    public static void printResultBar() {
        System.out.println(LOTTO_RESULT_BAR_MESSAGE);
    }

    public static void printResult(Map<Prize, Integer> lottoResult) {
        lottoResult.entrySet().stream()
                .filter(entry -> entry.getKey() != Prize.FAIL)
                .forEach(entry -> System.out.println(getPrintResult(entry.getKey(), entry.getValue())));
    }

    public static String getPrintResult(Prize prize, int count) {
        if (prize == Prize.SECOND_GRADE) {
            return String.format(LOTTO_SECOND_RESULT_MESSAGE
                    , prize.getMatchCount()
                    , String.format("%,d", prize.getReward())
                    , count);
        }
        return String.format(LOTTO_RESULT_MESSAGE
                , prize.getMatchCount()
                , String.format("%,d", prize.getReward())
                , count);
    }

    public static void printTotalRate(double totalRate) {
        System.out.printf(TOTAL_RATE_MESSAGE, totalRate);
    }

}
