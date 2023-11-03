package lotto.domain;

public class Ticket {

    private final int price = 1000;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int moneyInput) {
        this.count = moneyInput / this.price;
    }
}
