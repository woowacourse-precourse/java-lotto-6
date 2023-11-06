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

    public static void printWinResult(List<Integer> winCnts, long containBonusCnt, long notContainBonusCnt) {
        System.out.printf(
                "3개 일치 (5,000원) - %d개\n"
                        + "4개 일치 (50,000원) - %d개\n"
                        + "5개 일치 (1,500,000원) - %d개\n"
                        + "5개 일치, 보너스 불 일치 (30,000,000원) - %d개\n"
                        + "6개 일치 (2,000,000,000원) - %d개"
                , winCnts.stream().filter(num -> num == 3).count()
                , winCnts.stream().filter(num -> num == 4).count()
                , containBonusCnt
                , notContainBonusCnt
                , winCnts.stream().filter(num -> num == 6).count()
        );
    }
}
