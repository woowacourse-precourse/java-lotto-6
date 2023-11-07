package lotto;

public enum Score {
    FIRST(2_000_000_000, "6개 일치 (2,000,000,000원) - %d개\n"),
    SECOND(30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    THIRD(1_500_000, "5개 일치 (1,500,000원) - %d개\n"),
    FOURTH(50_000, "4개 일치 (50,000원) - %d개\n"),
    FIFTH(5_000, "3개 일치 (5,000원) - %d개\n"),
    NONE(0, null);

    private final int price;
    private final String message;

    Score(int price, String message) {
        this.price = price;
        this.message = message;
    }

    public int getPrice() {
        return price;
    }

    public String getMessage() {
        return message;
    }

}
