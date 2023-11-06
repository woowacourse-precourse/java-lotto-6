package lotto.domain;

import java.util.Arrays;

public enum Prize {
    EMPTY(0, 0, false, ""),
    FIFTH(5_000, 3, false, "3개 일치 (5,000원) - "),
    FOURTH(50_000, 4, false, "4개 일치 (50,000원) - "),
    THIRD(1_500_000, 5, false, "5개 일치 (1,500,000원) - "),
    SECOND(30_000_000, 5, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(2_000_000_000, 6, false, "6개 일치 (2,000,000,000원) - ");

    private final int prizeAmount;
    private final int matchCount;
    private final boolean containBonus;
    private final String message;

    Prize(final int prizeAmount, final int matchCount, final boolean containBonus, String message){
        this.prizeAmount = prizeAmount;
        this.matchCount = matchCount;
        this.containBonus = containBonus;
        this.message = message;
    }

    public static Prize getResult(int matchCount, boolean containBonus){
        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == matchCount)
                .filter(prize -> prize.containBonus == containBonus)
                .findAny()
                .orElse(EMPTY);
    }

    public String getMessage() {
        return this.message;
    }

    public int getPrizeAmount(){
        return this.prizeAmount;
    }
}