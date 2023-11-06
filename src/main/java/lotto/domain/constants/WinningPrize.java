package lotto.domain.constants;

public enum WinningPrize {

    CORRECT_SIX_NUMBERS_PRICE(2_000_000_000),
    CORRECT_FIVE_NUMBERS_WITH_BONUS_NUMBER_PRICE(30_000_000),
    CORRECT_FIVE_NUMBERS_PRICE(1_500_000),
    CORRECT_FOUR_NUMBERS_PRICE(50_000),
    CORRECT_THREE_NUMBERS_PRICE(5_000),
    CORRECT_TWO_NUMBERS_PRICE(0),
    CORRECT_ONE_NUMBER_PRICE(0),
    CORRECT_ZERO_NUMBER_PRICE(0);

    private final long price;

    WinningPrize(long price) {
        this.price = price;
    }

    public long getPrice() {
        return price;
    }
}
