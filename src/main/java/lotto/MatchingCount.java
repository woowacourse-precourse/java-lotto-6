package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public enum MatchingCount {

    THREE(3, 5000,false),
    FOUR(4, 50000,false),
    FIVE(5, 15000000,false),
    FIVE_BONUS(5, 30000000,true),
    SIX(6,2000000000, false);

    private final int matchCount;
    private final int prizeMoney;
    private final boolean bonusNumber;

    MatchingCount(int matchCount, int prizeMoney, boolean bonusNumber) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.bonusNumber = bonusNumber;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static MatchingCount findByMatchCount (int count, boolean hasBonus){
        if(count == 5){
            return Arrays.stream(MatchingCount.values())
                    .filter( MatchingCount -> MatchingCount.matchCount == count)
                    .filter( MatchingCount -> MatchingCount.bonusNumber == hasBonus)
                    .findAny()
                    .orElse(null);
        }
        return Arrays.stream(MatchingCount.values())
                .filter( MatchingCount -> MatchingCount.matchCount == count)
                .findAny()
                .orElse(null);
   }
}
