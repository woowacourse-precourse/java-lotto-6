package lotto.utils;

import java.util.Arrays;

public enum LottoCompare {
    FIRST("6개 일치 (2,000,000,000원)", 6, false,2000000000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 5, true,30000000),
    THIRD("5개 일치 (1,500,000원)", 5, false,1500000),
    FOURTH("4개 일치 (50,000원)", 4, false,50000),
    FIFTH("3개 일치 (5,000원)", 3, false, 5000),
    NONE("0", 0, false, 0);

    private final String label;
    private final int match;
    private final boolean needBonus;
    private final int prize;

    LottoCompare(String label, int match, boolean needBonus, int prize) {
        this.label = label;
        this.match = match;
        this.needBonus = needBonus;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public String getLabel() {
        return label;
    }

    public static LottoCompare getCompareResult(int match, boolean needBonus) {
        if(match == SECOND.match && needBonus != SECOND.needBonus) {
            return THIRD;
        }
        if(match < FIFTH.match) {
            return NONE;
        }
        return Arrays.stream(LottoCompare.values())
                .filter(i -> i.match == match)
                .findAny()
                .orElseThrow(IllegalStateException::new);
    }

}
