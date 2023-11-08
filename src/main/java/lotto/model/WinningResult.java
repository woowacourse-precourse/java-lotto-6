package lotto.model;

public enum WinningResult {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(7, 30000000),
    FIRST(6, 2000000000);

    private final int value;
    private final int price;

    WinningResult(int value, int price) {
        this.value = value;
        this.price = price;
    }

    public static WinningResult getWinningPrice(int count) {
        for (WinningResult winningResult : WinningResult.values()) {
            if (count == winningResult.value) {
                return winningResult;
            }
        }
        return null;
    }

    public int getPrice() {
        return price;
    }

    public int getValue() {
        return value;
    }
}
