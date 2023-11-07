package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public enum LottoRank {
    NO_RANK(0, List.of(0L, 1L, 2L), "0"),
    FIRST(1, List.of(6L), "2000000000"),
    SECOND(2, List.of(5L), "30000000"),
    THIRD(3, List.of(5L), "1500000"),
    FOURTH(4, List.of(4L), "50000"),
    FIFTH(5, List.of(3L), "5000");

    private static final int WINNING_RANK_INDEX = 0;

    private final int rank;
    private final List<Long> matchCount;
    private final String winningMoney;

    LottoRank(int rank, List<Long> matchCount, String winningMoney) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public static LottoRank getLottoRank(long matchCount, boolean isMatchBonusNumber) {
        List<LottoRank> lottoWinningRanks = Arrays.stream(LottoRank.values())
                .filter(lottoWinningRank ->
                        lottoWinningRank.getMatchCount()
                                .contains(matchCount))
                .collect(Collectors.toList());

        if (lottoWinningRanks.contains(SECOND) && lottoWinningRanks.contains(THIRD)) {
            fiveMatchOrFiveBonusNumberMatch(isMatchBonusNumber, lottoWinningRanks);
        }

        return lottoWinningRanks.get(WINNING_RANK_INDEX);
    }

    private static void fiveMatchOrFiveBonusNumberMatch(boolean isMatchBonusNumber, List<LottoRank> lottoWinningRanks) {
        if (isMatchBonusNumber) {
            lottoWinningRanks.remove(THIRD);
        }
        if (!isMatchBonusNumber) {
            lottoWinningRanks.remove(SECOND);
        }
    }

    public int getRank() {
        return rank;
    }

    public List<Long> getMatchCount() {
        return matchCount;
    }

    public String getWinningMoney() {
        return winningMoney;
    }
}
