package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    private static final String RATE_OF_RETURN = "총 수익률은 %2.f%% 입니다.";
    private static final String PURCHASE_QUANTITY = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS =
            """
            
            당첨통계
            ---""";

    public void printLottos(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public void printPurchaseQuantity(int quantity) {
        System.out.println();
        System.out.println(String.format(PURCHASE_QUANTITY, quantity));
    }

    public void printRateOfReturn() {
        System.out.println(RATE_OF_RETURN);
    }

    public void printWinningStatistics() {
        System.out.println(WINNING_STATISTICS);
    }

}
