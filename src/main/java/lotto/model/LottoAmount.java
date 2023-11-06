package lotto.model;

public class LottoAmount {

    private static final int LOTTO_PRICE = 1000;

    private final int amount;

    public LottoAmount(String amount) {
        validateAmount(amount);
        this.amount = Integer.parseInt(amount);
    }

    public int getLottoCount() {
        return amount / LOTTO_PRICE;
    }

    public int getAmount() {
        return amount;
    }

    private void validateAmount(String amount) {
        int amountSum = Integer.parseInt(amount);
        if (amountSum % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("로또 금액을 1000원 단위로 입력해주세요.");
        }
    }
}
