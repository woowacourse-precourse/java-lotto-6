package lotto.Model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000), // 1등
    SECOND(5, 30_000_000), // 2등 (보너스 번호)
    THIRD(5, 1_500_000), // 3등
    FOURTH(4, 50_000), // 4등
    FIFTH(3, 5_000), // 5등
    MISS(2, 0);

    private final int matchNumber;
    private final int prizeMoney;

    Rank(int matchNumber, int prizeMoney){
        this.matchNumber = matchNumber;
        this.prizeMoney = prizeMoney;
    }

    public static Rank getPrizeType(int matchNumber, boolean bonus){
        if (SECOND.isPrizeRank(matchNumber) && bonus){
            return SECOND;
        } else if (THIRD.isPrizeRank(matchNumber) && !bonus){
            return THIRD;
        }
        return Arrays.stream(Rank.values())
                .filter(prizeRank -> prizeRank.isPrizeRank(matchNumber))
                .findAny().orElse(MISS);
    }

    public String getWinningMessage(int count){
        if (isBonusPrize(matchNumber, prizeMoney)){
            return String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", matchNumber, prizeMoney, count);
        }
        return String.format("%d개 일치 (%,d원) - %,d개", matchNumber, prizeMoney, count);
    }
    private boolean isBonusPrize(int matchNumber, int prizeMoney){
        return matchNumber == SECOND.getMatchNumber()&& prizeMoney == SECOND.getPrizeMoney();
    }
    private boolean isPrizeRank(int matchNumber){
        return this.matchNumber == matchNumber;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
