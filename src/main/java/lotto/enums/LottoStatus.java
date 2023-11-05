package lotto.enums;

public enum LottoStatus {
    FIRST(6,2000000000L),
    SECOND(5,30000000L),
    THIRD(5,1500000L),
    FOURTH(4,50000L),
    FIFTH(3,5000L),
    SIXTH(0,0L);
    private final int correctCount;
    private final Long prize;

    LottoStatus(int correctCount, long prize) {
        this.correctCount = correctCount;
        this.prize = prize;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public Long getPrize() {
        return prize;
    }

}
