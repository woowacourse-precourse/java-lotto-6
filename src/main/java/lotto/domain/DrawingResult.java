package lotto.domain;

public enum DrawingResult {
    FIRST(2_000_000_000, false, 6),
    SECOND(30_000_000, true, 5),
    THIRD(1_500_000, false, 5),
    FOURTH(50_000, false, 4),
    FIFTH(5_000, false, 3);

    private final int matchNumberCount;
    private final boolean hasBonus;
    private final int WinningAmount;

    DrawingResult(int matchNumberCount, boolean hasBonus, int winningAmount) {
        this.matchNumberCount = matchNumberCount;
        this.hasBonus = hasBonus;
        WinningAmount = winningAmount;
    }
}
