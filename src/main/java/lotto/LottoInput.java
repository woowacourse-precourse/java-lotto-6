package lotto;

public class LottoInput {

    private final int amount;

    public LottoInput(int amount) {
        checkPurchaseAmount(amount);
        this.amount = amount;
    }
    private void checkPurchaseAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR]구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

}
