package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class LottoResult {
    public static final int INIT_COUNT = 0;

    private final Map<LottoRank, Integer> result;

    private LottoResult(Map<LottoRank, Integer> result) {
        this.result = result;
    }

    public static LottoResult create() {
        EnumMap<LottoRank, Integer> result = new EnumMap<>(LottoRank.class);
        Arrays.stream(LottoRank.values())
                .forEach(lottoRank -> result.put(lottoRank, INIT_COUNT));

        return new LottoResult(result);
    }

    public void addLottoRankCount(List<LottoRank> lottoRanks) {
        for (LottoRank lottoRank : lottoRanks) {
            addCount(lottoRank);
        }
    }

    private void addCount(LottoRank lottoRank) {
        result.put(lottoRank, result.get(lottoRank) + 1);
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
        return result.entrySet().stream()
                .filter(entry -> entry.getKey().isNotNothing())
                .collect(Collectors.toUnmodifiableMap(Entry::getKey, Entry::getValue));
    }
}
