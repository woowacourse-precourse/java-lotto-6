package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    private static final String RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";
    private static final String PURCHASE_QUANTITY = "%d개를 구매했습니다.";

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

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println(String.format(RATE_OF_RETURN, rateOfReturn));
    }
}
