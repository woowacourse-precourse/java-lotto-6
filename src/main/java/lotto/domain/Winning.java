package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Winning {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    BLANK(2, 0);

    private final int matchNumbers;
    private final int prizeMoney;

    Winning(int matchNumbers, int prizeMoney) {
        this.matchNumbers = matchNumbers;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchNumbers() {
        return matchNumbers;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static List<Winning> getValues() {
        List<Winning> winningHistoryValues = Stream.of(Winning.values())
                .filter(rankType -> rankType.matchNumbers >= 3)
                .collect(Collectors.toList());
        Collections.reverse(winningHistoryValues);
        return winningHistoryValues;
    }

    public static Winning getWinningType(int matchNumbers, boolean matchBonus) {
        return Arrays.stream(Winning.values())
                .filter(rankData -> rankData.isRankData(rankData, matchNumbers, matchBonus))
                .findAny().orElse(BLANK);
    }

    private boolean isRankData(Winning rankData, int matchNumbers, boolean matchBonus) {
        if (isSecond(rankData) && matchBonus) {
            return isMatchNumber(rankData.matchNumbers, matchNumbers);
        }
        if (isThird(rankData) && !matchBonus) {
            return isMatchNumber(rankData.matchNumbers, matchNumbers);
        }
        if (!isSecond(rankData) && !isThird(rankData)) {
            return isMatchNumber(rankData.matchNumbers, matchNumbers);
        }
        return false;
    }

    private boolean isSecond(Winning rankData) {
        return rankData == SECOND;
    }

    private boolean isThird(Winning rankData) {
        return rankData == THIRD;
    }

    private boolean isMatchNumber(int rankMatchNumbers, int matchNumbers) {
        return rankMatchNumbers == matchNumbers;
    }

    public String getStaticsMessage(int count) {
        if (isSecond(matchNumbers, prizeMoney)) {
            return String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", matchNumbers, prizeMoney, count);
        }

        return String.format("%d개 일치 (%,d원) - %,d개", matchNumbers, prizeMoney, count);
    }

    private boolean isSecond(int matchNumbers, int prizeMoney) {
        return matchNumbers == SECOND.getMatchNumbers() && prizeMoney == SECOND.getPrizeMoney();
    }
}
