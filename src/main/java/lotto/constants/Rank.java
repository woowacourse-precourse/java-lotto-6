package lotto.constants;

public enum Rank {
    FIRST(2000000000, 6, "6개 일치 (2,000,000,000원) - "),
    SECOND(30000000, 5, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(1500000, 5, "5개 일치 (1,500,000원) - "),
    FOURTH(50000, 4, "4개 일치 (50,000원) - "),
    FIFTH(5000, 3, "3개 일치 (5,000원) - ");

    private final String message;
    private final int prize;
    private final int count;

    Rank(int prize, int count, String Message) {
        this.prize = prize;
        this.message = Message;
        this.count = count;
    }

    public int getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }

    public String getMessage() {
        return message;
    }
}