package lotto.view;

public class OutputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String EARNING_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.";
    private static final String STATUS = "당첨 통계";
    private static final String THREE_DASH = "---";
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final int HUNDRED = 100;

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printNewLine() {
        System.out.println();
    }

    public void requestAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
    }

    public void requestWinningNumber() {
        System.out.println(WINNING_NUMBER_MESSAGE);
    }

    public void requestBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public void printUserLotto(long lottoCount, String lotto) {
        System.out.printf(PURCHASE_MESSAGE + NEW_LINE, lottoCount);
        System.out.println(lotto);
        System.out.println();
    }

    public void printStatistics(String statistics) {
        System.out.println(STATUS);
        System.out.println(THREE_DASH);
        System.out.println(statistics);
    }

    public void printEarningRate(long purchaseAmount, long revenue) {
        double earningRate = ((double)revenue / purchaseAmount) * HUNDRED;

        System.out.printf(EARNING_RATE_MESSAGE + NEW_LINE, earningRate);
    }
}
