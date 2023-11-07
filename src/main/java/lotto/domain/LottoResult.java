package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    public static final int INIT_COUNT = 0;

    private final Map<LottoRank, Integer> result;

    private LottoResult(Map<LottoRank, Integer> result) {
        this.result = result;
    }

    public static LottoResult create() {
        EnumMap<LottoRank, Integer> result = new EnumMap<>(LottoRank.class);
        Arrays.stream(LottoRank.values())
                .filter(LottoRank::isNotNothing)
                .forEach(lottoRank -> result.put(lottoRank, INIT_COUNT));

        return new LottoResult(result);
    }

    public void addLottoRankCount(List<LottoRank> lottoRanks) {
        for (LottoRank lottoRank : lottoRanks) {
            addCount(lottoRank);
        }
    }

    public void addCount(LottoRank lottoRank) {
        result.computeIfPresent(lottoRank, (LottoRank key, Integer value) -> ++value);
    }

    public double calculateTotalReturn(Money money) {
        return ((double) sumOrPrizeAmount() / money.getMoney()) * 100;
    }

    private int sumOrPrizeAmount() {
        return result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().calculatePrizeAmount(entry.getValue()))
                .sum();
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }
}
