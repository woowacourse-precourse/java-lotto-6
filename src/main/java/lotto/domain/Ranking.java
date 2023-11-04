package lotto.domain;

public enum Ranking {
    FIRST("6개 일치", "2,000,000,000"),
    SECOND("5개 일치, 보너스 볼 일치", "30,000,000"),
    THIRD("5개 일치", "1,500,000"),
    FOURTH("4개 일치", "50,000"),
    FIFTH("3개 일치", "5,000");

    private final String description;
    private final String prize;

    private Ranking(String description, String prize) {
        this.description = description;
        this.prize = prize;
    }

    public String getDescription() {
        return description;
    }

    public String getPrize() {
        return prize;
    }
}
