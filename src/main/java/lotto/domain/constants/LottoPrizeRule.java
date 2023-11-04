package lotto.domain.constants;

import java.util.*;

public enum LottoPrizeRule {
    FIRST_PRIZE(1, 6, false, 2000000000),
    SECOND_PRIZE(2, 5, true, 30000000),
    THIRD_PRIZE(3, 5, false, 1500000),
    FOURTH_PRIZE(4, 4, false, 50000),
    FIFTH_PRIZE(5, 3, false, 5000);

    private final int place;
    private final int matchedNumbersCount;
    private final boolean hasBonusNumber;
    private final int prize;

    LottoPrizeRule(int place, int matchedNumbersCount, boolean hasBonusNumber, int prize) {
        this.place = place;
        this.matchedNumbersCount = matchedNumbersCount;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
    }

    public static void initWinningStatistics(Map<Integer, Integer> winningStatistics) {
        Arrays.stream(LottoPrizeRule.values())
                .forEach(prizeRule -> winningStatistics.put(prizeRule.getPlace(), 0));
    }

    public static int findPlaceByRule(int lottoMatchedNumbersCount, boolean hasLottoBonusNumber) {
        int place = 0;

        Optional<LottoPrizeRule> matchedPlace = Arrays.stream(LottoPrizeRule.values())
                .filter(prizeRule -> prizeRule.hasSameRule(lottoMatchedNumbersCount, hasLottoBonusNumber))
                .findAny();

        if (matchedPlace.isPresent()) {
            place = matchedPlace.get().getPlace();
        }

        return place;
    }

    public static int getPrizeByPlace(int lottoPlace, int wonLottoCount) {
        int prize = 0;

        Optional<LottoPrizeRule> matchedPrize = Arrays.stream(LottoPrizeRule.values())
                .filter(place -> place.isSamePlace(lottoPlace))
                .findAny();

        if (matchedPrize.isPresent()) {
            prize = matchedPrize.get().getPrizeByCount(wonLottoCount);
        }

        return prize;
    }

    private int getPlace() {
        return place;
    }

    private boolean hasSameRule(int matchCount, boolean hasBonusNumber) {
        return (this.matchedNumbersCount == matchCount) && (this.hasBonusNumber == hasBonusNumber);
    }

    private boolean isSamePlace(int place) {
        return this.place == place;
    }

    private int getPrizeByCount(int lottoCount) {
        return prize * lottoCount;
    }
}