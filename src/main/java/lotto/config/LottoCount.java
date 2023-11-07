package lotto.config;

public enum LottoCount {
    LOTTO_COUNT(6);

    private int count;
    LottoCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
