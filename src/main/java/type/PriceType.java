package type;

public enum PriceType {
    FIRST("(2,000,000,000원)", "2,000,000,000", 6),
    SECOND("(30,000,000원)", "30,000,000", 7),
    THIRD("(1,500,000원)", "1,500,000", 5),
    FOURTH("(50,000원)", "50,000", 4),
    FIFTH("(5,000원)", "5,000", 3),
    BONUS("보너스 볼 일치", "", 0);

    private final String text;
    private final String price;
    private final int count;

    PriceType(String text, String price, int count) {
        this.text = text;
        this.price = price;
        this.count = count;
    }

    public String getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public String getText() {
        return text;
    }
}
