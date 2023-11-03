package lotto.view;

public class OutputView {
    private static final String EARNING_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.";
    private static final String STATUS = "당첨 통계";
    private static final String THREE_DASH = "---";
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final int HUNDREAD = 100;

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printUserLottos(int lottosCount, String lottos) {
        System.out.println();
        System.out.printf(PURCHASE_MESSAGE + NEW_LINE, lottosCount);
        System.out.println(lottos);
        System.out.println();
    }

    public void printResults(String result) {
        System.out.println(STATUS);
        System.out.println(THREE_DASH);
        System.out.println(result);
    }

    public void printEarningRate(int purchaseAmount, long revenue) {
        double earningRate = ((double) revenue / purchaseAmount) * HUNDREAD;
        System.out.printf(EARNING_RATE_MESSAGE + NEW_LINE, earningRate);
    }
}
