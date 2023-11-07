package lotto;

public enum Score {
    FIRST(6, 200000000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"), // 보너스 번호 일치하는 경우
    THIRD(5, 1500000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50000, "4개 일치 (50,000원)"),
    FIFTH(3, 5000, "3개 일치 (5,000원)");

    private final int correctCount;
    private final int prize;
    private final String message;

    Score(int correctCount, int prize, String message) {
        this.correctCount = correctCount;
        this.prize = prize;
        this.message = message;
    }

    public int getCorrectCount() {
        return correctCount;
    }
    public int getPrize() {
        return prize;
    }
    public String getMessage() {
        return message;
    }
    public static Score valueOf(int correctCount) {
        for(Score score : values()) {
            if(score.getCorrectCount() == correctCount) {
                return score;
            }
        }
        return null;
    }
}
