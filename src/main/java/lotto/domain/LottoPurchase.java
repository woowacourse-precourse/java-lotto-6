package lotto.domain;

public class LottoPurchase {
    private int count;

    public void buyLottos(int money) {
        this.count = money / 1000;
    }

    public int getCount() {
        return count;
    }
}
