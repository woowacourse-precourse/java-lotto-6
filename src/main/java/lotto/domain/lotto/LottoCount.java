package lotto.domain.lotto;

public class LottoCount {

    private static final int DIVIDE_UNIT = 1000;
    private final int count;

    public LottoCount(Price price) {
        this.count = (int) (price.getAmount() / DIVIDE_UNIT);
    }

    public int getCount() {
        return count;
    }
}
