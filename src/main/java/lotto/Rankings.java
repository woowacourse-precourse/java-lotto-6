package lotto;

import java.util.Arrays;

public enum Rankings {
    FIRST(6, false, 200000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NOTHING(0, false, 0);

    private final Integer winNumberCount;
    private final boolean needBonusBall;
    private final Integer amount;


    Rankings(Integer winNumberCount, boolean needBonusBall, Integer amount) {
        this.winNumberCount = winNumberCount;
        this.needBonusBall = needBonusBall;
        this.amount = amount;
    }

    public static Rankings getRanking(Integer winNumberCount, boolean needBonusBall) {
        if(winNumberCount == SECOND.winNumberCount && !needBonusBall) {
            return THIRD;
        }

        return Arrays.stream(values())
                .filter(ranking -> ranking.winNumberCount == winNumberCount)
                .findFirst()
                .orElse(NOTHING);
    }

    public Integer getAmount() {
        return amount;
    }

}
