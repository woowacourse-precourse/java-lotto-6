package lotto.view;

import java.util.Map;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Rank;

public class OutputView {
    private static final String PURCHASED_MESSAGE = "%d개를 구매했습니다.%n";
    private static final String RESULT_MESSAGE = "당첨 통계\n---";
    private static final String FIFTH = "3개 일치 (5,000원) - %d개\n";
    private static final String FOURTH = "4개 일치 (50,000원) - %d개\n";
    private static final String THIRD = "5개 일치 (1,500,000원) - %d개\n";
    private static final String SECOND = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String FIRST = "6개 일치 (2,000,000,000원) - %d개\n";
    private static final String RATE = "총 수익률은 %.1f%%입니다.";
    public static void printLottoQuantity(Money money) {
        System.out.printf(PURCHASED_MESSAGE, money.getLottoQuantity());
    }

    public static void printLottoList(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
        System.out.println();
    }

    public static void printResult(Map<Rank, Integer> lottoResult) {
        System.out.println(RESULT_MESSAGE);
        System.out.printf(FIFTH, lottoResult.getOrDefault(Rank.FIFTH, 0));
        System.out.printf(FOURTH, lottoResult.getOrDefault(Rank.FOURTH, 0));
        System.out.printf(THIRD, lottoResult.getOrDefault(Rank.THIRD, 0));
        System.out.printf(SECOND, lottoResult.getOrDefault(Rank.SECOND, 0));
        System.out.printf(FIRST, lottoResult.getOrDefault(Rank.FIRST, 0));
    }

    public static void printRate(Map<Rank, Integer> lottoResult, Money money) {
        double totalPrize = lottoResult.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        double rate = (totalPrize / money.getMoney()) * 100;

        System.out.printf(RATE, rate);

    }
}
