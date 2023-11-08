package lotto.constant;

public enum LottoResultIndex {
    SECOND_RANK_INDEX(1),
    FIFTH_RANK_MATCH_INDEX(3),
    FIRST_RANK_MATCH_INDEX(6);

    private final int index;

    LottoResultIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}