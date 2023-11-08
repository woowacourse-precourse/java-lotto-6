package lotto.view;

public class LottoOutputView {

    public static final String PURCHASE_INFO_MESSAGE = "%d개를 구매했습니다.";
    public static final String STATISTIC_INFO_MESSAGE = "당첨 통계" + "\n---";

    public static final String RESULT_MESSAGE = "총 수익률은 %.1f%%입니다.";


    public void purchaseInfoLog(final int quantity) {
        System.out.printf((PURCHASE_INFO_MESSAGE) + "%n", quantity);
    }

    public void showStatisticLog() {
        System.out.println(STATISTIC_INFO_MESSAGE);
    }

    public void showResultLog(double result) {
        System.out.printf(RESULT_MESSAGE, result);
    }
}
