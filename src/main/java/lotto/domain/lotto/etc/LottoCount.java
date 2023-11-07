package lotto.domain.lotto.etc;

public class LottoCount {
    private final static int UNIT = 1000;
    private static int count;

    public LottoCount(int amount) {
        amountUnitValidate(amount);
        this.count = amount / UNIT;
    }

    private void amountUnitValidate(int amount) {
        if (amount % UNIT != 0 || amount / UNIT == 0) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요.");
        }
    }

    public int getLottoCount() {
        return count;
    }
}
