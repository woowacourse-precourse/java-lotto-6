package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class MatchingCounts {
    private static final int MINIMUM_COUNT_FOR_PRIZE = 3;
    private static final int REQUIRED_COUNT_FOR_BONUS = 5;
    private static final int NUMBER_OF_PRIZES = 5;
    public static final int LOTTO_FIRST_PRIZE_COUNT = 6;

    private static final List<Integer> matchingCounts = new ArrayList<>(NUMBER_OF_PRIZES);

    public MatchingCounts() {
        for (int i = 0; i < NUMBER_OF_PRIZES; i++) {
            matchingCounts.add(0);
        }
    }

    public static void displayWinningInfo(int count, int bonus) {
        int index = determineIndex(count, bonus);
        updateMatchingCounts(index);
    }

    private static int determineIndex(int count, int bonus) {
        if (isBetween3And5(count)) {
            return getIndexBetween3And5(count, bonus);
        }

        if (count == LOTTO_FIRST_PRIZE_COUNT) {
            return 4;
        }

        return -1;
    }

    private static boolean isBetween3And5(int count) {
        return count >= MINIMUM_COUNT_FOR_PRIZE && count <= REQUIRED_COUNT_FOR_BONUS;
    }

    private static int getIndexBetween3And5(int count, int bonus) {
        if (count == REQUIRED_COUNT_FOR_BONUS && bonus == 1) {
            return 3;
        }
        return count - 3;
    }

    private static void updateMatchingCounts(int index) {
        if (index != -1) {
            matchingCounts.set(index, matchingCounts.get(index) + 1);
        }
    }

    public List<Integer> getMatchingCount() {
        return matchingCounts;
    }
}