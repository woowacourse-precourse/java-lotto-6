package lotto.domain.purchase.issue;

public enum LottoNumberRangePolicy {
    START_RANGE(1),
    END_RANGE(45);

    int range;

    LottoNumberRangePolicy(int range) {
        this.range = range;
    }

    public int getRange() {
        return range;
    }
}
