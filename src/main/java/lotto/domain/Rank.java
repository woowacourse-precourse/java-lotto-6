package lotto.domain;

public enum Rank {

    FIFTH(3, 5_000, "3개 일치 (5,000원) - %d개\n"),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - %d개\n"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - %d개\n"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개\n");

    private int count;
    private int prize;
    private String message;
    Rank(int count, int prize, String message) {
        this.count = count;
        this.prize = prize;
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}
