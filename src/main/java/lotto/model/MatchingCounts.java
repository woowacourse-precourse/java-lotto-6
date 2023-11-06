package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class MatchingCounts {
    private final List<Integer> matchingCounts = new ArrayList<>(7);

    public MatchingCounts() {
        for (int i = 0; i < 7; i++) {
            matchingCounts.add(0);
        }
    }

    public void displayWinningInfo(int count, int bonus) {
        if (count >= 3 && count <= 6) {
            int index = count;
            if (count == 5 && bonus == 1) {
                index = 6;
            }
            matchingCounts.set(index-1, matchingCounts.get(index) + 1);
        }
    }

    public List<Integer> getMatchingCount(){
        return matchingCounts;
    }
}
