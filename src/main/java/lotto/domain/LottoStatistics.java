package lotto.domain;

import lotto.constant.LottoRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public class LottoStatistics {

    private final EnumMap<LottoRank, Integer> statistics;

    public LottoStatistics(List<Lotto> lottoPack, Result result) {
        this.statistics = buildStatistics(lottoPack, result);
    }

    private EnumMap<LottoRank, Integer> buildStatistics(List<Lotto> lottoPack, Result result) {

        EnumMap<LottoRank, Integer> statistics = new EnumMap<>(LottoRank.class);
        Arrays.stream(LottoRank.values()).forEach(lottoRank -> statistics.put(lottoRank, 0));

        lottoPack.stream()
                .map(lotto -> lotto.calculate(result))
                .forEach(rank -> statistics.put(rank, statistics.get(rank) + 1));

        return statistics;

    }

    @Override
    public String toString() {

        List<String> response = new ArrayList<>();

        statistics.forEach((rank, count) -> {
            response.add(buildLine(rank, count));
        });

        return String.join("\n", response);

    }

    private String buildLine(LottoRank rank, Integer count) {
        return rank.toString() + String.format(" - %d개", count);
    }

    public int calculateIncome() {
        return statistics.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

}
