package lotto.Model;

import static lotto.View.OutputView.PrintCountLotto.printCountLotto;

public class CountLotto {

    public static final int PURCHASE_UNIT = 1000;

    private final int countLotto;

    public CountLotto(int amount) {
        this.countLotto = caluculateAmount(amount);

        printCountLotto(getCountLotto());
    }

    private int caluculateAmount(int amount) {
        return amount / PURCHASE_UNIT;
    }

    public int getCountLotto() {
        return this.countLotto;
    }

}
