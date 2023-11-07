package lotto.Model;

public class UserLottoAmount {
    private static final int LOTTO_PRICE = 1000;
    private final int amount;

    public UserLottoAmount(int amount) {
        this.amount = amount;
    }

    public int CalcLottoCount() {
        return amount / LOTTO_PRICE;
    }
}
