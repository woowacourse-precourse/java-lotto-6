package lotto.enums;

public enum WinningMessage {

    RANK5(5, "3개 일치 (5,000원) - "),
    RANK4(4, "4개 일치 (50,000원) - "),
    RANK3(3, "5개 일치 (1,500,000원) - "),
    RANK2(2, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    RANK1(1, "6개 일치 (2,000,000,000원) - ");
    private final int rank;
    private final String message;

    WinningMessage(int rank, String message) {
        this.rank = rank;
        this.message = message;
    }

    public int getRank() {
        return rank;
    }

    public String getMessage() {
        return message;
    }
}
