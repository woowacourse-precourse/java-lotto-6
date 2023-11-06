package lotto.Constants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottosConstants {
    SIX_MATCH (6, 2_000_000_000),
    FIVE_MATCH_BONUS (5, 30_000_000),
    FIVE_MATCH (5, 1_500_000),
    FOUR_MATCH (4, 50_000),
    THREE_MATCH (3, 5_000),
    NONE (2, 0);

    private final int matchNumber;
    private final int prizeMoney;

    LottosConstants(int matchNumber, int prizeMoney){
        this.matchNumber = matchNumber;
        this.prizeMoney = prizeMoney;
    }

    public static LottosConstants getPrizeType(int matchNumber, boolean bonus){
        if (FIVE_MATCH_BONUS.isPrizeRank(matchNumber) && bonus){
            return FIVE_MATCH_BONUS;
        } else if (FIVE_MATCH.isPrizeRank(matchNumber) && !bonus){
            return FIVE_MATCH;
        }
        return Arrays.stream(LottosConstants.values())
                .filter(prizeRank -> prizeRank.isPrizeRank(matchNumber))
                .findAny().orElse(NONE);
    }

    private boolean isPrizeRank(int matchNumber){
        return this.matchNumber == matchNumber;
    }

    public String getWinningMessage(int count){
        if (isBonusPrize(matchNumber, prizeMoney)){
            return String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", matchNumber, prizeMoney, count);
        }
        return String.format("%d개 일치 (%,d원) - %,d개", matchNumber, prizeMoney, count);
    }

    private boolean isBonusPrize(int matchNumber, int prizeMoney){
        return matchNumber == FIVE_MATCH_BONUS.getMatchNumber()&& prizeMoney == FIVE_MATCH_BONUS.getPrizeMoney();
    }

    public int getMatchNumber() {
        return this.matchNumber;
    }

    public int getPrizeMoney(){
        return this.prizeMoney;
    }
}
