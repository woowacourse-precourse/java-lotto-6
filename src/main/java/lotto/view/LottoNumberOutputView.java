package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class LottoNumberOutputView {
    private static final String PURCHASE_NUM_MESSAGE = "개를 구매했습니다.";

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + PURCHASE_NUM_MESSAGE);
        for (Lotto lotto : lottos) {
            List<Integer> sortedNumbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(sortedNumbers);
            System.out.println(sortedNumbers.toString());
        }
        System.out.println();
    }
}
