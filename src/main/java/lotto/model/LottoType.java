package lotto.model;


import java.util.Arrays;

public enum LottoType {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    NONE(0, 0);

    private final int matchCount;
    private final int winningMoney;

    LottoType(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public static LottoType of(int matchCount, boolean bonus) {
        if(matchCount == 5 && bonus) return SECOND;
        return Arrays.stream(values())
                .filter(resultType -> resultType.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
