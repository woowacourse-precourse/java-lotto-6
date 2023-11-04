package lotto.view;

public class OutputView {

    private final static String PURCHASE_QUANTITY = "%d개를 구매했습니다.";
    private final static String WINNING_STATISTICS = "당첨 통계";

    public void printPurchaseQuantity(int quantity) {
        System.out.println(String.format(PURCHASE_QUANTITY, quantity));
    }

    public void printWinningStatistics() {
        System.out.println(WINNING_STATISTICS);
    }

}
