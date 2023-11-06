package lotto.Model;

public class RandomLotto {
    private int count;

    public RandomLotto(Price price) {
        this.count = price.divideWithOneThousands();
    }

    public int getCount() {
        return count;
    }
}
