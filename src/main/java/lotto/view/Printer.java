package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class Printer {
    private static final String LOTTO_PURCHASED_MESSAGE = "%d개를 구매했습니다.";
    public static void printPurchasedLottoQuantity(long quantity) {
        System.out.printf(LOTTO_PURCHASED_MESSAGE, quantity);
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
