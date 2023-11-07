package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum PrizeRankConstants {
    RANK_5TH(5_000, "3개 일치 (5,000원)", (numberOfMatched, isBonusMatched) -> {
        return (numberOfMatched == 3);
    }),
    RANK_4TH(50_000, "4개 일치 (50,000원)", (numberOfMatched, isBonusMatched) -> {
        return (numberOfMatched == 4);
    }),
    RANK_3RD(1_500_000, "5개 일치 (1,500,000원)", (numberOfMatched, isBonusMatched) -> {
        return (!isBonusMatched && numberOfMatched == 5);
    }),
    RANK_2ND(30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)", (numberOfMatched, isBonusMatched) -> {
        return (isBonusMatched && numberOfMatched == 5);
    }),
    RANK_1ST(2_000_000_000, "6개 일치 (2,000,000,000원)", (numberOfMatched, isBonusMatched) -> {
        return (numberOfMatched == 6);
    });


    private final Integer earnings;
    private final String message;
    private final BiPredicate<Integer, Boolean> isMatched;

    PrizeRankConstants(
            Integer earnings,
            String message,
            BiPredicate<Integer, Boolean> isMatched
    ) {
        this.earnings = earnings;
        this.message = message;
        this.isMatched = isMatched;
    }

    public String getMessage() {
        return message;
    }

    public Integer getEarnings() {
        return earnings;
    }

    public static PrizeRankConstants getRankConstant(Integer numberOfMatched, boolean isBonusMatched) {
        return Arrays.stream(PrizeRankConstants.values())
                .filter(rank -> rank.isMatched.test(numberOfMatched, isBonusMatched))
                .findAny()
                .orElse(null);
    }
}
