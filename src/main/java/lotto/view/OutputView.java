package lotto.view;

import lotto.utils.PrizeType;

public class OutputView {
    private final static String PURCHASE_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private final static String DRAWING_STATISTIC_MESSAGE = "\n당첨 통계 \n---";

    public static void printPurchaseAmount(Integer amount) {
        System.out.println("\n" + amount + PURCHASE_AMOUNT_MESSAGE);
    }

    public static void printLottoTicket(String lottoTicket) {
        System.out.println(lottoTicket);
    }

    public static void printLottoStatisticStartMessage() {
        System.out.println(DRAWING_STATISTIC_MESSAGE);
    }

    public static void printLottoStatistic(PrizeType type, Integer amount) {
        System.out.println(type.getDescription() + " - " + amount + "개");
    }
}
