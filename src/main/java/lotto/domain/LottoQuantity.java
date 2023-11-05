package lotto.domain;

public class LottoQuantity {

    private int quantity;

    public LottoQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean decreaseOneByOne() {
        quantity--;
        return quantity >= 0;
    }
}
