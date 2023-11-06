package lotto.view;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;

public class OutputView {

    public static void printLottoCount(int lottoCount) {
        System.out.printf("%d개를 구매했습니다.%n", lottoCount);
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(Arrays.toString(lotto.getNumbers().toArray())));
    }

    public static void printLottoResult(int[] result) {
        System.out.printf(
                """
                당첨 통계
                ---
                3개 일치 (5,000원) - %d개
                4개 일치 (50,000원) - %d개
                5개 일치 (1,500,000원) - %d개
                5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
                6개 일치 (2,000,000,000원) - %d개
                """, result[1], result[2], result[3], result[0], result[4]
        );
    }

    public static void printLottoProfit(double profit) {
        System.out.printf("총 수익률은 %.1f%%입니다.", profit);
    }
}
