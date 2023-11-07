package lotto.domain;

public class Result {
    private final int hitResult;
    private final int bonusResult;

    public Result(int hitResult, int bonusResult) {
        this.hitResult = hitResult;
        this.bonusResult = bonusResult;
    }

    public int getHitResult() {
        return hitResult;
    }

    public int getBonusResult() {
        return bonusResult;
    }
}
