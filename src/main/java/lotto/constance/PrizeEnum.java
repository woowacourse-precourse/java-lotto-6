package lotto.constance;

public enum PrizeEnum {
    FIFTH(5_000, "3개 일치 (%s원) - %d개","FIFTH"),
    FOURTH(50_000, "4개 일치 (%s원) - %d개", "FOURTH"),
    THIRD(1_500_000, "5개 일치 (%s원) - %d개", "THIRD"),
    SECOND(30_000_000, "5개 일치, 보너스 볼 일치 (%s원) - %d개", "SECOND"),
    FIRST(2_000_000_000, "6개 일치 (%s원) - %d개", "FIRST");

    private int amount;
    private String Comment;
    private String Key;

    PrizeEnum(int amount, String comment, String key) {
        this.amount = amount;
        this.Comment = comment;
        this.Key = key;
    }

    public int getAmount() {
        return amount;
    }

    public String getComment() {
        return Comment;
    }

    public String getKey() {
        return Key;
    }
}
