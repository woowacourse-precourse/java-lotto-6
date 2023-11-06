package lotto.model;

import java.util.Arrays;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class LottoResult {

    private final Map<LottoRank, Integer> checkResult;

    public LottoResult() {
        this.checkResult = getLottoResultMap();
    }

    private static Map<LottoRank, Integer> getLottoResultMap() {
        return Arrays.stream(LottoRank.values())
            .collect(Collectors.toMap(rank -> rank, rank -> 0));
    }

    public void increaseRankCount(final LottoRank rank) {
        checkResult.replace(rank, checkResult.get(rank) + 1);
    }

    public String toOutputString() {
        final StringJoiner joiner = new StringJoiner("\n");
        Arrays.stream(LottoRank.values())
            .forEach(lottoRank -> addRankOutputString(joiner, lottoRank));
        return joiner.toString();
    }

    private void addRankOutputString(final StringJoiner joiner, final LottoRank lottoRank) {
        final Integer rankCount = checkResult.get(lottoRank);
        joiner.add(lottoRank.getOutputString(rankCount));
    }

}