package config;

public enum CountMessage {

    FIFTH("3개 일치 (5,000원) - %d개\n", 3, 5_000d),
    FOURTH("4개 일치 (50,000원) - %d개\n", 4, 50_000d),
    THIRD("5개 일치 (1,500,000원) - %d개\n", 5, 1_500_000d),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", 7, 30_000_000d),
    FIRST("6개 일치 (2,000,000,000원) - %d개\n", 6, 2_000_000_000d);

    private final String message;
    private final Integer count;

    private final Double price;

    private CountMessage(String message, Integer count, Double price) {
        this.message = message;
        this.count = count;
        this.price = price;
    }

    public String getMessage() {
        return message;
    }

    public int getCount() {
        return count;
    }

    public Double getPrice() {
        return price;
    }
}
