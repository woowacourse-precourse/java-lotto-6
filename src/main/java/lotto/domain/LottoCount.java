package lotto.domain;

public class LottoCount {
    private final int count;

    public LottoCount(int count) {
        this.count = count;
    }

    public static LottoCount from(int purchase) {
        int count = purchase / 1000;
        return new LottoCount(count);
    }

    public int getCount() {
        return count;
    }
}
