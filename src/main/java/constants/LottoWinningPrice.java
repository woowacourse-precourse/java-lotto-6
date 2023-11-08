package constants;

public enum LottoWinningPrice {

    WINNING_3_PRICE("5000"),
    WINNING_4_PRICE("50000"),
    WINNING_5_PRICE("1500000"),
    WINNING_5_BONUS_PRICE("30000000"),
    WINNING_6_PRICE("2000000000");

    private final String price;

    LottoWinningPrice(String price){
        this.price = price;
    }

    public String getPrice() {
        return price;
    }
}
