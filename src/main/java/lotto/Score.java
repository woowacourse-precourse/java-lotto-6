package lotto;

public enum Score {
    FIRST(6, 200000000),
    SECOND(5, 30000000), // 보너스 번호 일치하는 경우
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int correctCount;
    private final int prize;

    Score(int correctCount, int prize) {
        this.correctCount = correctCount;
        this.prize = prize;
    }

    public int getCorrectCount() {
        return correctCount;
    }
    public int getPrize() {
        return prize;
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
