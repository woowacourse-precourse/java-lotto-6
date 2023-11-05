package lotto.model;

public enum Result {

    FIFTH("3개 일치 (5,000원)", 5_000),
    THIRD("5개 일치 (1,500,000원)", 1_500_000),
    FOURTH("4개 일치 (50,000원)", 50_000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000),
    FIRST("6개 일치 (2,000,000,000원)", 2_000_000_000);

    private final String message;

    private final int prize;

    Result(String message, int prize) {
        this.message = message;
        this.prize = prize;
    }

    public String getMessage() {
        return message;
    }

    public int getPrize() {
        return prize;
    }
}
