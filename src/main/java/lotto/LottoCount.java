package lotto;

public class LottoCount {
    private final static int UNIT = 1000;
    private static int count;

    public LottoCount(int amount) {
        this.count = amount;
    }

    private void amountUnitValidate(int amount) {
        if (amount % UNIT != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요.");
        }
    }

    public int getCount() {
        return count;
    }
}
