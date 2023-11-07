package lotto.type;

public enum Win {

    FIRST(7, 2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND(6, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 1500000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50000, "4개 일치 (50,000원) - "),
    FIFTH(3, 5000, "3개 일치 (5,000원) - ");

    private int collectCount;
    private int prize;
    private String message;

    Win(int collectCount, int prize, String message) {
        this.collectCount = collectCount;
        this.prize = prize;
        this.message = message;
    }

    public int getCollectCount() {
        return this.collectCount;
    }

    public int getPrize() {
        return this.prize;
    }

    public String getMessage() {
        return this.message;
    }
}
