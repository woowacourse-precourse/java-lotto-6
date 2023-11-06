package lotto.enums;

public enum LottoWinningResult {
    THREE_WIN(3, 5_000)
    , FOUR_WIN(4, 50_000)
    , FIVE_WIN(5, 1_500_000)
    , FIVE_WITH_BONUS(50, 30_000_000)
    , SIX_WIN(6, 2_000_000_000);

    private final int number;
    private final int price;

    LottoWinningResult(int number, int price) {
        this.number = number;
        this.price = price;
    }
}
