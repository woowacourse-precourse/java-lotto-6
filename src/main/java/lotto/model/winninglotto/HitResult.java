package lotto.model.winninglotto;

public class HitResult {

    private final int hitCount;
    private final boolean isBonusBallHit;

    protected HitResult(int hitCount, boolean isBonusBallHit) {
        this.hitCount = hitCount;
        this.isBonusBallHit = isBonusBallHit;
    }

    protected int getHitCount() {
        return hitCount;
    }

    protected boolean getIsBonusBallHit() {
        return isBonusBallHit;
    }
}
