package lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST_PLACE(6,"6개 일치 (2,000,000,000원) - %d개", 2000000000),
    SECOND_PLACE(5, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", 30000000),
    THIRD_PLACE(5, "5개 일치 (1,500,000원) - %d개", 1500000),
    FOURTH_PLACE(4, "4개 일치 (50,000원) - %d개", 50000),
    FIFTH_PLACE(3, "3개 일치 (5,000원) - %d개", 5000),
    LAST_PLACE(2, "", 0);

    private int matchCount;
    private String message;
    private int reward;

    Rank(int matchCount, String message, int reward) {
        this.matchCount = matchCount;
        this.message = message;
        this.reward = reward;
    }

    public static Rank calculate(int matchCount, boolean hasBonusNumber){
        if(matchCount == THIRD_PLACE.matchCount && !hasBonusNumber){
            return THIRD_PLACE;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst().orElse(LAST_PLACE);
    }
}
