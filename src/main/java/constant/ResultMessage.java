package constant;

public enum ResultMessage {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_WITH_BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000);

    private final int matchNumber;
    private final int price;

    ResultMessage(int matchNumber, int price) {
        this.matchNumber = matchNumber;
        this.price = price;
    }
    public int getMatchNumber() {
        return matchNumber;
    }
    public int getPrice(){
        return price;
    }
}
