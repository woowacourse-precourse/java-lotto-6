package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class MatchingCounts {
    private static final List<Integer> matchingCounts = new ArrayList<>(5);

    public MatchingCounts() {
        for (int i = 0; i < 5; i++) {
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

        if (count == 6) {
            return 4;
        }

        return -1;
    }

    private static boolean isBetween3And5(int count) {
        return count >= 3 && count <= 5;
    }

    private static int getIndexBetween3And5(int count, int bonus) {
        if (count == 5 && bonus == 1) {
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