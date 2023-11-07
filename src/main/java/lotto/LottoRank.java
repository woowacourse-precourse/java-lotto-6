package lotto;

public enum LottoRank {
    FIRST(1, 2000000000, "6개 일치 (2,000,000,000원)"),
    SECOND(2, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(3, 1500000, "5개 일치 (1,500,000원)"),
    FORTH(4, 50000, "4개 일치 (50,000원)"),
    FIFTH(5, 5000, "3개 일치 (5,000원)"),
    SIXTH(6, 0, "");

    public final int prize;
    public final long reward;
    public final String description;

    LottoRank(int prize, int reward, String description) {
        this.prize = prize;
        this.reward = reward;
        this.description = description;
    }
}
