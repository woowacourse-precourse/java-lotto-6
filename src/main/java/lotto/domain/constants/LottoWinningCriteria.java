package lotto.domain.constants;

import java.util.*;

public enum LottoWinningCriteria {
    FIRST_PRIZE_CRITERIA(1, 6, false),
    SECOND_PRIZE_CRITERIA(2, 5, true),
    THIRD_PRIZE_CRITERIA(3, 5, false),
    FOURTH_PRIZE_CRITERIA(4, 4, false),
    FIFTH_PRIZE_CRITERIA(5, 3, false);

    private final int place;
    private final int matchCount;
    private final boolean hasBonusNumber;

    LottoWinningCriteria(int place, int matchCount, boolean hasBonusNumber) {
        this.place = place;
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static int findPlace(int matchCount, boolean hasBonusNumber) {
        int place = 0;

        Optional<LottoWinningCriteria> matchedCriteria = Arrays.stream(LottoWinningCriteria.values())
                .filter(count -> count.isMatched(matchCount))
                .filter(number -> number.hasBonusNumber(hasBonusNumber))
                .findAny();

        if (matchedCriteria.isPresent()) {
            place = matchedCriteria.get().getPlace();
        }

        return place;
    }

    private boolean isMatched(int matchCount) {
        return this.matchCount == matchCount;
    }

    private boolean hasBonusNumber(boolean hasBonusNumber) {
        return this.hasBonusNumber == hasBonusNumber;
    }

    public int getPlace() {
        return place;
    }

    public static void initStatistics(Map<Integer, Integer> statistics) {
        Arrays.stream(LottoWinningCriteria.values())
                .forEach(criteria -> statistics.put(criteria.getPlace(), 0));
    }
}