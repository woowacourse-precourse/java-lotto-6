package lotto.view;

import lotto.domain.Lotto;
import java.util.List;

public class OutputView {

    public static void printLottos(int count, List<Lotto> lottos) {
        System.out.println("\n" + count + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
