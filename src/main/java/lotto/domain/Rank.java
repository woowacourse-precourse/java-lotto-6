package lotto.domain;

public enum Rank {
    LOSE(0, 0, "낙첨 (%d원) - %d개"),
    FIFTH(3,5_000, "3개 일치 (%d원) - %d개"),
    FOURTH(4, 50_000, "4개 일치 (%d원) - %d개"),
    THIRD(5, 1_500_000, "5개 일치 (%d원) - %d개"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (%d원) - %d개"),
    FIRST(6, 2_000_000_000, "6개 일치 (%d원) - %d개");

    private final int match;
    private final int prize;
    private final String message;

    Rank(int match, int prize, String message) {
        this.match = match;
        this.prize = prize;
        this.message = message;
    }
}
