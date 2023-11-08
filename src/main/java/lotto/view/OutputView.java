package lotto.view;

public class OutputView {

    private static final String PURCHASE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계\n---\n";
    private static final String RATE_OF_RETURN = "총 수익률은 %s%%입니다.";

    public void printPurchase(int count) {
        System.out.println(count + PURCHASE);
    }

    public void printLottoHistory(String history) {
        System.out.println(history);
    }

    public void printWinningStatistics(String lottoResult) {
        System.out.print(WINNING_STATISTICS + lottoResult);
    }

    public void printRateOfReturn(String rate) {
        System.out.println(String.format(RATE_OF_RETURN,rate));
    }
}
