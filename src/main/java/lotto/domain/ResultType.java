package lotto.domain;

public enum ResultType {
    THREE("3개 일치 (5,000원) - ",5000),
    FOUR("4개 일치 (50,000원) - ", 50000),
    FIVE("5개 일치 (1,500,000원) - ",1500000),
    FIVEBONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - ",30000000),
    SIX("6개 일치 (2,000,000,000원) - ",2000000000),
    NOTHING("당첨되지 않았습니다.",0);
    private final String description;
    private final int prize;

    ResultType(String description, int prize) {
        this.description = description;
        this.prize = prize;
    }

    public String getDescription() {
        return description;
    }
    public int getPrize() {
        return prize;
    }
}
