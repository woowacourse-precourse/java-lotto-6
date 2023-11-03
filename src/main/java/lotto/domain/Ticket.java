package lotto.domain;

public class Ticket {

    private static final int price = 1000;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int moneyInput) {
        if (moneyInput % price == 0) {
            this.count = moneyInput / this.price;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
