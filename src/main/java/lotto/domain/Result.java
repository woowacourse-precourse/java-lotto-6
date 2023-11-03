package lotto.domain;

public class Result {

    private final long sameNumberCount;

    private final long sameBonusCount;

    private Result(final long sameNumberCount, final long sameBonusCount) {
        this.sameNumberCount = sameNumberCount;
        this.sameBonusCount = sameBonusCount;
    }

    public static Result of(final Lotto lotto, final WinnerNumbers winnerNumbers) {
        return new Result(lotto.calculateSameCount(winnerNumbers),
                lotto.calculateSameBonusCount(winnerNumbers));
    }

    public long getSameNumberCount() {
        return sameNumberCount;
    }

    public long getSameBonusCount() {
        return sameBonusCount;
    }
}
