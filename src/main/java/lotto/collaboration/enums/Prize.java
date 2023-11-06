package lotto.collaboration.enums;

import java.util.Arrays;

public enum Prize {

    LOST(0, "불일치", 0, 0L),
    FIFTH(5, "3개 일치 (5,000원)", 3, 5_000L),
    FOURTH(4, "4개 일치 (50,000원)", 4, 50_000L),
    THIRD(3, "5개 일치 (1,500,000원)", 5, 1_500_000L),
    SECOND(2, "5개 일치, 보너스 볼 일치 (30,000,000원)", 5, 30_000_000L),
    FIRST(1, "6개 일치 (2,000,000,000원)", 6, 2_000_000_000L),
    ;

    private final int rank;
    private final String message;
    private final int countOfGuess;
    private final long money;

    Prize(int rank, String message, int countOfGuess, long money) {
        this.rank = rank;
        this.message = message;
        this.countOfGuess = countOfGuess;
        this.money = money;
    }

    public static Prize matchPrize(int resultOfMatchNumbers, boolean resultOfMatchBonusNumber) {
        if (resultOfMatchBonusNumber && resultOfMatchNumbers == 5) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(prize -> prize.countOfGuess == resultOfMatchNumbers)
                .findFirst()
                .orElse(LOST);
    }

    public String message() {
        return message;
    }

    public int rank() {
        return rank;
    }

    public long money() {
        return money;
    }

}
