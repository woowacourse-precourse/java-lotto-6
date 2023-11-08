package type;

public enum PriceType {
    FIRST("(2,000,000,000원)", 6),
    SECOND("(30,000,000원)", 7),
    THIRD("(1,500,000원)", 5),
    FOURTH("(50,000원)", 4),
    FIFTH("(5,000원)", 3),
    BONUS("보너스 볼 일치", 0);

    private final String price;
    private final int count;

    PriceType (String result, int count){
        this.price = result;
        this.count = count;
    }

    public String getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }
}
