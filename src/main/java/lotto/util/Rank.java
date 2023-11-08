package lotto.util;

public enum Rank {
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 1500000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50000, "4개 일치 (50,000원) - "),
    FIFTH(3, 5000, "3개 일치 (5,000원) - "),
    NONE(0, 0, "");

    private final int matchingCount;
    private final int prize;

    private final String outputMessage;

    Rank(int matchingCount, int prize, String outputMessage) {
        this.matchingCount = matchingCount;
        this.prize = prize;
        this.outputMessage = outputMessage;
    }

    public static Rank fromMatchingCount(int count) {
        for (Rank result : values()) {
            if (result.matchingCount == count) {
                return result;
            }
        }
        return NONE; // Default to NONE if no match is found
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getOutputMessage() {
        return outputMessage;
    }
}
