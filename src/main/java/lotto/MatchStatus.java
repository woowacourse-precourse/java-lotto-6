package lotto;

public enum MatchStatus {
    THREE_MATCH(5000),
    FOUR_MATCH(50000),
    FIVE_MATCH(1500000),
    FIVE_AND_BONUS_MATCH(30000000),
    SIX_MATCH(2000000000);

    private final int price;

    MatchStatus(int price) {
        this.price = price;
    }

    public int getPrice(){
        return price;
    }
}
