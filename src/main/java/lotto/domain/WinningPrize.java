package lotto.domain;

public enum WinningPrize {
    THREE_MATCH(5000,"3개 일치(5,000원)"),
    FOUR_MATCH(50000,"4개 일치(50,000원)"),
    FIVE_MATCH(1500000,"5개 일치(1,500,000원)"),
    BONUS_MATCH(30000000,"5개 일치, 보너스 볼 일치(30,000,000원)"),
    SIX_MATCH(2000000000,"6개 일치(2,000,000,000원)");

    private final int price;
    private final String message;
    WinningPrize(int price, String message){
        this.price = price;
        this.message = message;
    }
}
