package lotto.cashier;

public class ReceivedAmount {

    private static final int LOTTO_PRICE = 1000;

    private final int amount;

    private ReceivedAmount(int amount) {
        validateIsLottoPrice(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public static ReceivedAmount create(int amount) {
        return new ReceivedAmount(amount);
    }
    private void validateIsLottoPrice(int amount) {
        if (amount < LOTTO_PRICE || (amount % LOTTO_PRICE) != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 1000원단위 금액입니다.");
        }
    }
}
