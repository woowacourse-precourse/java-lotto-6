package lotto.enums;

public enum LottoStatus {
    FIRST(6, 2000000000L, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30000000L, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1500000L, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50000L, "4개 일치 (50,000원)"),
    FIFTH(3, 5000L, "3개 일치 (5,000원)"),
    SIXTH(0, 0L, "3개 이하 일치(0원)");
    private final int correctCount;
    private final Long prize;
    private final String statusMessage;

    LottoStatus(int correctCount, long prize, String statusMessage) {
        this.correctCount = correctCount;
        this.prize = prize;
        this.statusMessage = statusMessage;
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

    public String getStatusMessage() {
        return statusMessage;
    }

}
