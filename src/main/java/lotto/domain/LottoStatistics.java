package lotto.domain;

import lotto.constant.LottoRank;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

    private final EnumMap<LottoRank, Integer> statistics;

    public LottoStatistics(LottoPack lottoPack, Result result) {

        statistics = new EnumMap<>(LottoRank.class);
        Arrays.stream(LottoRank.values())
                .forEach(lottoRank -> statistics.put(lottoRank, 0));

        lottoPack.calculate(result)
                .forEach(rank -> statistics.put(rank, statistics.get(rank) + 1));

    }

    @Override
    public String toString() {
        List<String> response = buildStrings();
        return String.join("\n", response);
    }

    private List<String> buildStrings() {
        return statistics.entrySet().stream()
                .filter(pair -> pair.getKey() != LottoRank.NOTHING)
                .map(this::buildString)
                .toList();
    }

    private String buildString(Map.Entry<LottoRank, Integer> pair) {
        return buildString(pair.getKey(), pair.getValue());
    }

    private String buildString(LottoRank rank, Integer count) {
        return rank.toString(count);
    }

    public int calculateIncome() {
        return statistics.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

}
