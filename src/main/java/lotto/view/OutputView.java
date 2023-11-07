package lotto.view;

public class OutputView {

    private static final String BUYING_COUNT_FORMAT = "%d개를 구매했습니다.";
    private static final String RESULT_STATISTICS = """
            당첨 통계
            ---""";

    public void printBuyingResults(final int buyingCount, final String resultMessage) {
        System.out.printf(BUYING_COUNT_FORMAT, buyingCount);
        System.out.println();
        System.out.println(resultMessage);
    }

    public void printWinningResult(final String message) {
        System.out.println(RESULT_STATISTICS);
        System.out.println(message);
    }
}
