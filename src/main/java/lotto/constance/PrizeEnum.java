package lotto.constance;

public enum PrizeEnum {
    FIFTH(5_000, "3개 일치 (%s원) - %d개"),
    FOURTH(50_000, "4개 일치 (%s원) - %d개"),
    THIRD(1_500_000, "5개 일치 (%s원) - %d개"),
    SECOND(30_000_000, "5개 일치, 보너스 볼 일치 (%s원) - %d개"),
    FIRST(2_000_000_000, "6개 일치 (%s원) - %d개");

    private int amount;
    private String Comment;

    PrizeEnum(int amount, String comment) {
        this.amount = amount;
        this.Comment = comment;
    }

    public int getAmount() {
        return amount;
    }

    public String getComment() {
        return Comment;
    }
}
