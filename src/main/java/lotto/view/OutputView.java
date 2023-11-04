package lotto.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class OutputView {
    public static void printLottoCount(int number) {
        System.out.println(number + "개를 구매했습니다.");
    }

    public static void printPurchasedLotto(Set<Integer> lotto) {
        System.out.println(lotto);
    }

    public static void printWinningStatisics(List<Integer> lotto) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lotto.get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + lotto.get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lotto.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lotto.get(3) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lotto.get(4) + "개");
    }

    public static void printRateOfReturn(BigDecimal rate) {
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}
