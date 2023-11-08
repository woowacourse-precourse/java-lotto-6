package lotto.model;

public final class HitsNumber {
    private int hitsNumberCnt;
    private int hitsBonusNumberCnt;

    public HitsNumber(int hitsNumberCnt, int hitsBonusNumberCnt) {
        this.hitsNumberCnt = hitsNumberCnt;
        this.hitsBonusNumberCnt = hitsBonusNumberCnt;
    }

    public int getHitsNumberCnt() {
        return hitsNumberCnt;
    }

    public int getHitsBonusNumberCnt() {
        return hitsBonusNumberCnt;
    }
}