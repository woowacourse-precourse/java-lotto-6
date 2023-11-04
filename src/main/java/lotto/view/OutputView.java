package lotto.view;

public class OutputView {

    private final static String PURCHASE_QUANTITY = "%d개를 구매했습니다.";
    private final static String WINNING_STATISTICS = "당첨 통계";
    private final static String LOTTO_RESULT = """
            ---
            3개 일치 (5,000원) - %d개
            4개 일치 (50,000원) - %d개
            5개 일치 (1,500,000원) - %d개
            5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
            6개 일치 (2,000,000,000원) - %d개
            """;

    public void printPurchaseQuantity(int quantity) {
        System.out.println(String.format(PURCHASE_QUANTITY, quantity));
    }

    public void printWinningStatistics() {
        System.out.println(WINNING_STATISTICS);
    }

    public static void printLottoResult() {
        System.out.println(String.format(LOTTO_RESULT));
    }
}
