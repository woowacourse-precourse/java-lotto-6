package lotto.domain;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1000;
    private static final String FORMAT_QUANTITY = "\n%d개를 구매했습니다.";
    int amount;

    public PurchaseAmount(String inputAmount) {
        int amount = Integer.parseInt(inputAmount);
        validate(amount);
        this.amount = amount;
    }

    public int getQuantity() {
        return amount / LOTTO_PRICE;
    }

    public String getResult() {
        int quantity = getQuantity();
        return String.format(FORMAT_QUANTITY, quantity);
    }

    private void validate(int amount) {
        if ((amount % LOTTO_PRICE) > 0) {
            throw new IllegalArgumentException();
        }
    }
}
