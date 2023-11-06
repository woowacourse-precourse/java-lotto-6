package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LottoResult {
    private static final Double PERCENT = 100.0;
    private static final String EACH_STAT = "%s (%,d원) - %d개\n";
    private static final String TOTAL_REVENUE = "총 수익률은 %.1f%%입니다.\n";
    private final Map<LottoRank, Integer> result;
    private final Double revenue;

    public LottoResult(LottoWithBonus answer, List<Lotto> randomLotto, Money money) {
        // 낮은 등수부터 순서대로 저장합니다.
        Map<LottoRank, Integer> allResult = new TreeMap<>(Collections.reverseOrder());
        for (LottoRank init : LottoRank.values()) {
            allResult.put(init, 0);
        }
        for (Lotto lotto : randomLotto) {
            LottoRank result = LottoComparator.getPlace(answer, lotto);
            allResult.put(result, allResult.get(result) + 1);
        }
        this.result = allResult;
        this.revenue = getRevenueFrom(money);
    }

    Double getRevenueFrom(Money money) {
        int totalProfit = 0;
        for (var rank : result.entrySet()) {
            totalProfit += rank.getKey().getPrize() * rank.getValue();
        }
        return (double) totalProfit / money.getMoney() * PERCENT;
    }

    @Override
    public String toString() {
        // 낮은 등수부터 순서대로 출력하고, 꽝은 건너뜁니다.
        StringBuilder ret = new StringBuilder();
        for (var rank : result.entrySet()) {
            if (rank.getKey() == LottoRank.NO_PRIZE) {
                continue;
            }

            LottoRank key = rank.getKey();
            ret.append(EACH_STAT.formatted(key.getResult(), key.getPrize(), rank.getValue()));
        }
        ret.append(TOTAL_REVENUE.formatted(revenue));
        return ret.toString();
    }
}
