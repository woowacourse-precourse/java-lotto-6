package lotto.domain;

public class MatchCount {
    private int matchCount;

    public void addMatchCount() {
        ++matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
