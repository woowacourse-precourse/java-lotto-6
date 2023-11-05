package lotto.domain;


public class WinningResult {
    private final int matchesCount;
    private final boolean isBonus;
    private WinningResult(int matchesCount, boolean isBonus){
        this.matchesCount = matchesCount;
        this.isBonus = isBonus;
    }

    public static WinningResult from(int matchesCount, boolean isBonus){
        return new WinningResult(matchesCount, isBonus);
    }
}
