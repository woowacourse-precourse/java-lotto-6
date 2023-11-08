package lotto;

public enum MatchType {
    THREE(3, 5000, "3개 일치 (5,000원)"),
    FOUR(4, 50000, "4개 일치 (50,000원)"),
    FIVE(5, 1500000, "5개 일치 (1,500,000원)"),
    FIVE_WITH_BONUS(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX(6, 200000000, "6개 일치 (2,000,000,000원)");

    private final int matchingNumbers;
    private final int prize;
    private final String outputString;

    MatchType(int matchingNumbers, int prize, String outputString) {
        this.matchingNumbers = matchingNumbers;
        this.prize = prize;
        this.outputString = outputString;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public int getPrize() {
        return prize;
    }
    
    public String getOutputString() {
        return outputString;
    }
}
