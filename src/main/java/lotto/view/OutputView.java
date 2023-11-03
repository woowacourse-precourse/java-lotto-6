package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    private final static String LOTTO_PURCHASE_MESSAGE = "%d개를 구매했습니다.";

    public static void printNumberOfLottoPurchase(int quantity) {
        System.out.println(String.format(LOTTO_PURCHASE_MESSAGE, quantity));
    }

    public static void printLottoList(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
