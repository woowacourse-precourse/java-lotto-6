package lotto.Model;

public class CountLotto {

    private final int PURCHASE_UNIT = 1000;
    private final int countLotto;

    public CountLotto(int amount) {
        countLotto = caluculateAmount(amount);
    }

    private int caluculateAmount(int amount) {
        return amount / PURCHASE_UNIT;
    }

    public int getCountLotto() {
        return countLotto;
    }

}
