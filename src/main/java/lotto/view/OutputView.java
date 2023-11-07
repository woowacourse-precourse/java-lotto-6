package lotto.view;

import java.util.List;
import lotto.Lotto;

public class OutputView {
    private static final String ISSUANCE_NUMBER_VIEW = "%d개를 구매했습니다.\n";

    public static void outputIssuance(int index, List<Lotto> lottos) {
        System.out.printf((ISSUANCE_NUMBER_VIEW), index);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }
}
