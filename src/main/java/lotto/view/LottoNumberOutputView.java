package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class LottoNumberOutputView {
    private static final String PURCHASE_NUM_MESSAGE = "개를 구매했습니다.";

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + PURCHASE_NUM_MESSAGE);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }
}
