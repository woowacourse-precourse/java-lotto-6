package lotto.view;

public class OutputView {
    private final static String NEW_LINE_MESSAGE = "\n";
    private final static String PURCHASE_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private final static String DRAWING_STATISTIC_MESSAGE = "\n당첨 통계 \n---";
    private final static String HYPHEN_MESSAGE = " - ";
    private final static String AMOUNT_UNIT = "개";
    private final static String TOTAL_EARNINGS_RATE_MESSAGE = "총 수익률은 ";
    private final static String SENTENCE_ENDING_MESSAGE = "%입니다.\n";

    public static void printPurchaseAmount(Integer amount) {
        System.out.println(NEW_LINE_MESSAGE + amount + PURCHASE_AMOUNT_MESSAGE);
    }

    public static void printLottoTicket(String lottoTicket) {
        System.out.println(lottoTicket);
    }

    public static void printLottoStatisticStartMessage() {
        System.out.println(DRAWING_STATISTIC_MESSAGE);
    }

    public static void printLottoStatistic(String description, Integer amount) {
        System.out.println(description + HYPHEN_MESSAGE + amount + AMOUNT_UNIT);
    }

    public static void printEarningsRate(String earningsRate) {
        System.out.println(TOTAL_EARNINGS_RATE_MESSAGE + earningsRate + SENTENCE_ENDING_MESSAGE);
    }
}
