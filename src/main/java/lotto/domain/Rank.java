package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST_PRIZE(6, 2_000_000_000),
    SECOND_PRIZE(5, 30_000_000),
    THIRD_PRIZE(5, 1_500_000),
    FOURTH_PRIZE(4, 50_000),
    FIFTH_PRIZE(3, 5_000),
    BLANK(2, 0);
    private final int matchNumbers;
    private final int prizeMoney;

    Rank(int matchNumbers, int prizeMoney) {
        this.matchNumbers = matchNumbers;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchNumbers() {
        return matchNumbers;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static List<Rank> getValues() {
        List<Rank> winningHistoryValues = Stream.of(Rank.values())
                .filter(rankType -> rankType.matchNumbers >= 3)
                .collect(Collectors.toList());
        Collections.reverse(winningHistoryValues);
        return winningHistoryValues;
    }

    public static Rank getWinningHistoryType(int matchNumbers, boolean matchBonus) {
        return Arrays.stream(Rank.values())
                .filter(rankData -> rankData.isRankData(rankData, matchNumbers, matchBonus))
                .findAny().orElse(BLANK);
    }

    private boolean isRankData(Rank rankData, int matchNumbers, boolean matchBonus) {
        if (isSecondPrize(rankData) && matchBonus) {
            return isMatchNumber(rankData.matchNumbers, matchNumbers);
        }

        if (isThirdPrize(rankData) && !matchBonus) {
            return isMatchNumber(rankData.matchNumbers, matchNumbers);
        }

        if (!isSecondPrize(rankData) && !isThirdPrize(rankData)) {
            return isMatchNumber(rankData.matchNumbers, matchNumbers);
        }

        return false;
    }

    private boolean isSecondPrize(Rank rankData) {
        return rankData == SECOND_PRIZE;
    }

    private boolean isThirdPrize(Rank rankData) {
        return rankData == THIRD_PRIZE;
    }

    private boolean isMatchNumber(int rankMatchNumbers, int matchNumbers) {
        return rankMatchNumbers == matchNumbers;
    }

    public String getStaticsMessage(int count) {
        if (isSecondPrize(matchNumbers, prizeMoney)) {
            return String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", matchNumbers, prizeMoney, count);
        }

        return String.format("%d개 일치 (%,d원) - %,d개", matchNumbers, prizeMoney, count);
    }

    private boolean isSecondPrize(int matchNumbers, int prizeMoney) {
        return matchNumbers == SECOND_PRIZE.getMatchNumbers() && prizeMoney == SECOND_PRIZE.getPrizeMoney();
    }
}
