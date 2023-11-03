package lotto.view;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OutputView {
    private static final String EARNING_RATE_MESSAGE = "총 수익률은 %s%%입니다.";
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.";
    private static final String STATUS = "당첨 통계";
    private static final String THREE_DASH = "---";
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final int FIRST_DIGIT = 1;
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

    public void printStatistics(String statistics) {
        System.out.println(STATUS);
        System.out.println(THREE_DASH);
        System.out.println(statistics);
    }

    public void printEarningRate(int purchaseAmount, BigDecimal revenue) {
        // (revenue / purchaseAmount) * 100을 소수점 둘째 자리에서 반올림한 결과와 같음
        BigDecimal earningRate = revenue
                .multiply(new BigDecimal(HUNDREAD))
                .divide(new BigDecimal(purchaseAmount)
                        , FIRST_DIGIT
                        , RoundingMode.HALF_UP);

        System.out.printf(EARNING_RATE_MESSAGE + NEW_LINE, earningRate);
    }
}
