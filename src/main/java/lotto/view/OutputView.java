package lotto.view;

import java.util.Map;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Rank;

public class OutputView {
    public static void printLottoQuantity(Money money) {
        System.out.printf("%d개를 구매했습니다.%n", money.getLottoQuantity());
    }

    public static void printLottoList(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
        System.out.println();
    }

    public static void printResult(Map<Rank, Integer> lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", lottoResult.getOrDefault(Rank.FIFTH, 0));
        System.out.printf("4개 일치 (50,000원) - %d개\n", lottoResult.getOrDefault(Rank.FOURTH, 0));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", lottoResult.getOrDefault(Rank.THIRD, 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", lottoResult.getOrDefault(Rank.SECOND, 0));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", lottoResult.getOrDefault(Rank.FIRST, 0));
    }
}
