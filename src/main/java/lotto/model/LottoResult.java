package lotto.model;

import java.util.Arrays;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class LottoResult {

    private final Map<LottoRank, Integer> checkResult;

    public LottoResult() {
        this.checkResult = createLottoResultMap();
    }

    private static Map<LottoRank, Integer> createLottoResultMap() {
        return Arrays.stream(LottoRank.values())
            .collect(Collectors.toMap(rank -> rank, rank -> 0)); //TODO
    }

    public void increaseRankCount(final LottoRank rank) {
        checkResult.replace(rank, checkResult.get(rank) + 1);
    }

    public String toOutputString() {
        final StringJoiner joiner = new StringJoiner("\n");
        Arrays.stream(LottoRank.values())
            .filter(lottoRank -> lottoRank.getPrize() > 0)
            .forEach(lottoRank -> addRankOutputString(joiner, lottoRank));
        return joiner.toString();
    }

    private void addRankOutputString(final StringJoiner joiner, final LottoRank lottoRank) {
        final Integer rankCount = checkResult.get(lottoRank);
        joiner.add(lottoRank.getOutputString(rankCount));
    }

    public double getEarningsRate(final int purchaseAmount) {
        return getWinningAmount() * 100.0 / purchaseAmount;
    }

    private int getWinningAmount() {
        return Arrays.stream(LottoRank.values())
            .mapToInt(rank -> rank.getPrize() * checkResult.get(rank))
            .sum();
    }

}