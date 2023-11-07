package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class Output {
    private static final String LOTTO_COUNT_MESSAGE = "\n%d개를 구매했습니다.";

    private Output() {
    }

    public static void printPurchasedLottoNumbers(List<Lotto> lottos) {
        String formattedMessage = String.format(LOTTO_COUNT_MESSAGE, lottos.size());
        System.out.println(formattedMessage);

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }

        System.out.println();
    }
}
