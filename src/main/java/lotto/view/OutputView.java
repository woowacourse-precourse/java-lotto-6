package lotto.view;

public class OutputView {

    private final String PURCHASE = "개를 구매했습니다.";
    private final String WINNING_STATISTICS = "당첨 통계\n---\n";
    private final String RATE_OF_RETURN = "총 수익률은 %f% 입니다.";

    public void printPurchase(int count) {
        System.out.println(count + PURCHASE);
    }

    public void printLottoHistory(String history) {
        System.out.print(history);
    }

    public void printWinningStatistics(String lottoResult) {
        System.out.println(WINNING_STATISTICS + lottoResult);
    }

    public void printRateOfReturn(float rate) {
        System.out.println(String.format(RATE_OF_RETURN,rate));
    }
}
