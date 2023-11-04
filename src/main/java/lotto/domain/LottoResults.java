package lotto.domain;

import static lotto.domain.LottoRank.NO_PRIZE;
import static lotto.constant.ResultMessage.STAT_SUFFIX;

import java.util.List;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.stream.Collectors;

public class LottoResults {
    private final List<LottoResult> lottoResults;

    public LottoResults(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }

    @Override
    public String toString() {
        List<String> result = Arrays.stream(LottoRank.values())
                .map(this::joinResults)
                .collect(Collectors.toList());

        return String.join("\n", result);
    }

    // TODO: 하드 코딩 값 상수화하기
    public double getTotalProfit() {
        int investment = lottoResults.size() * 1_000;
        return (double) getSumOfPrize() / investment * 100;
    }

    private String joinResults(LottoRank rank) {
        EnumMap<LottoRank, Integer> rankCount = getRankCount();
        String suffix = String.format(STAT_SUFFIX.getMessage(),rankCount.getOrDefault(rank, 0));

        if (rank == NO_PRIZE) {
            return "";
        }
        return String.join("", rank.getMessage(), suffix);
    }


    private EnumMap<LottoRank, Integer> getRankCount() {
        EnumMap<LottoRank, Integer> rankCount = new EnumMap<>(LottoRank.class);

        lottoResults.stream()
                .map(LottoResult::getRank)
                .forEach(rank -> rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1));
        return rankCount;
    }

    private long getSumOfPrize() {
        return lottoResults.stream()
                .map(LottoResult::getLottoPrize)
                .mapToLong(Long::longValue)
                .sum();
    }
}
