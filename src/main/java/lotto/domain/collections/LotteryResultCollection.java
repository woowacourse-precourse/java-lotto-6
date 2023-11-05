package lotto.domain.collections;

import lotto.domain.LotteryResult;

import java.util.Collections;
import java.util.List;

import static lotto.domain.LotteryResult.NOTHING;

public class LotteryResultCollection {

    private final List<LotteryResult> results;

    private LotteryResultCollection(List<LotteryResult> results) {
        this.results = results;
    }

    public static LotteryResultCollection of(List<LotteryResult> results) {
        return new LotteryResultCollection(results);
    }

    public void printResults() {
        Long totalGainMoney = 0L;
        for (LotteryResult info : LotteryResult.values()) {
            if (info.equals(NOTHING)) continue;
            int count = Collections.frequency(results, info);
            totalGainMoney += (long) info.getLotteryMoney() * count;
            System.out.println(info + " - " + count + "개");
        }

        Long useMoney = results.size() * 1000L;
        double totalProfitRate = (double) totalGainMoney / useMoney * 100L;
        System.out.println(String.format("총 수익률은 %.2f%%입니다.", totalProfitRate));
    }
}
