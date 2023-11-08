package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Match {

    private final List<Integer> matchCounts;

    public Match() {
        this.matchCounts = new ArrayList<>(Collections.nCopies(8, 0));
    }

    public void incrementMatchCount(int matchCount) {
        if (matchCount != -1) {
            matchCounts.set(matchCount, matchCounts.get(matchCount) + 1);
        }
    }

    public List<Integer> getMatchCounts() {
        return matchCounts;
    }

    public int getSingleMatchCount(int index) {
        return matchCounts.get(index);
    }

    @Override
    public String toString() {
        return "Match{" +
                "matchCounts=" + matchCounts +
                '}';
    }
}
