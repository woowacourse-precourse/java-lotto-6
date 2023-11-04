package lotto.constant;

public enum LottoConstant {
    LOTTO_PRICE(1000),
    THREE_WINNINGS(5000),
    FOUR_WINNINGS(50000),
    FIVE_WINNINGS(1500000),
    FIVE_BONUS_WINNINGS(30000000),
    SIX_WINNINGS(2000000000);

    private final int number;

    LottoConstant(int number) {
        this.number = number;
    }

    public int getLottoConstant() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
