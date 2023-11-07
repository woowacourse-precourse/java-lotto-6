package lotto.Model;

public class RandomLotto {
    private int counting;

    public RandomLotto(Price price) {
        this.counting = price.countPurchasedLotto();
    }

    public int getCounting() {
        return counting;
    }
}
