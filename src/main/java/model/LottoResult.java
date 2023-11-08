package model;

public enum LottoResult {
    NON_CORRECT(0,0),
    THREE_CORRECT(3, 5000),
    FOUR_CORRECT(4, 50000),
    FIVE_CORRECT(5, 1500000),
    FIVE_AND_BONUS_CORRECT(5, 300000000),
    SIX_CORRECT(6, 2000000000);

    private final int correctNumber;
    private final int price;

    LottoResult(int correctNumber, int price) {
        this.correctNumber = correctNumber;
        this.price = price;
    }
}
