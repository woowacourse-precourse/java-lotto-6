package lotto.utils.io;

import lotto.domain.Lottos;
import lotto.domain.Prize;

import java.util.Arrays;
import java.util.Map;

public class OutputManager {
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.";
    private static final String STATISTIC_MESSAGE = "당첨 통계";
    private static final String SPLIT_LINE = "---";
    private static final String EARNING_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    private OutputManager() {
    }

    public static void printLottos(int lottoCount, Lottos lottos) {
        System.out.println();
        System.out.println(String.format(PURCHASE_MESSAGE, lottoCount));
        System.out.println(lottos);
    }

    public static void printResult(Map<Prize, Integer> result, int purchasePrice) {
        System.out.println(STATISTIC_MESSAGE);
        System.out.println(SPLIT_LINE);
        Arrays.asList(Prize.values())
                .forEach(prize -> {
                    String prizeResult = String.format(prize.getMessage(), result.get(prize));
                    System.out.println(prizeResult);
                });

        double earningRate = calculateEarningRate(result, purchasePrice);
        String earningRateResult = String.format(EARNING_RATE_MESSAGE, earningRate);
        System.out.println(earningRateResult);
    }

    public static double calculateEarningRate(Map<Prize, Integer> result, int purchasePrice) {
        long total = 0;
        for (Prize prize : Prize.values()) {
            long money = prize.getReward() * result.get(prize);
            total += money;
        }
        return (double) total / purchasePrice * 100;
    }
}
