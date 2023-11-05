package lotto.global.util;

import java.util.List;
import lotto.domain.Lotto;

public final class OutputManager {

    public static void printHistory(int totalCnt, List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", totalCnt);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
