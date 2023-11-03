package lotto.view;

public class OutputView {
    private static final String EARNING_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.";
    private static final String STATUS = "당첨 통계";
    private static final String THREE_DASH = "---";
    private static final String NEW_LINE = System.getProperty("line.separator");
    public void printUserLottos(int lottosCount, String lottos) {
        System.out.printf(PURCHASE_MESSAGE + NEW_LINE, lottosCount);
        System.out.println(lottos);
    }

    public void printResults(String result) {
        System.out.println(STATUS);
        System.out.println(THREE_DASH);
        System.out.println(result);
    }

    public void printEarningRate(int purchaseAmount, int revenue) {
        double earningRate = ((double)revenue / purchaseAmount) * 100;
        System.out.printf(EARNING_RATE_MESSAGE + NEW_LINE, earningRate);
    }
}
