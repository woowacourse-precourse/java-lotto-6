package lotto;

public enum LottoResult {
    FIRST("6개 일치", 2_000_000_000),
    SECOND("5개 일치, 보너스 일치", 30_000_000),
    THIRD("5개 일치", 1_500_000),
    FOURTH("4개 일치", 50_000),
    FIFTH("3개 일치", 5_000),
    NONE("당첨되지 않았습니다", 0);

    private String description;
    private int prize;

    LottoResult(String description, int price) {
        this.description = description;
        this.prize = price;
    }

    public String getDescription() {
        return description;
    }

    public int getPrize() {
        return prize;
    }
}
