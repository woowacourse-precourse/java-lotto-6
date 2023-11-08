package lotto.matcher;

public class MatchResult {
    private int matchingNumber;
    private boolean bonus;

    public MatchResult(int matchingNumber, boolean bonus) {
        this.matchingNumber = matchingNumber;
        this.bonus = bonus;
    }
}
