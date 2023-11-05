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

    public static LottoStatus getLottoStatus(int correctCount, boolean hasBonusNumber) {
        if (correctCount == LottoStatus.SECOND.correctCount && !hasBonusNumber) {
            return LottoStatus.THIRD;
        }
        for (LottoStatus lottoStatus : LottoStatus.values()) {
            if (lottoStatus.correctCount == correctCount) {
                return lottoStatus;
            }
        }
        return LottoStatus.SIXTH;
    }

    public Long getPrize() {
        return prize;
    }

}
