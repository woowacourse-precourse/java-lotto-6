package lotto.domain.lottery;

public class CountResult {
    private final int matchingCount;
    private final boolean matchingBonus;

    private CountResult(
            int matchingCount,
            boolean matchingBonus
    ) {
        this.matchingCount = matchingCount;
        this.matchingBonus = matchingBonus;
    }

    public static CountResult of()
}
