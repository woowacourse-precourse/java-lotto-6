package lotto.model.data;

import static lotto.util.AmountOfLotto.LOTTO_PRICE;

import lotto.model.record.Money;
import lotto.model.record.NumberOfLotto;

public class LottoRecipe {
    private final Money money;
    private NumberOfLotto numberOfLotto;

    private LottoRecipe(Money money) {
        this.money = money;
    }

    public static LottoRecipe from(Money money) {
        return new LottoRecipe(money);
    }

    public Money getMoney() {
        return money;
    }

    public NumberOfLotto purchaseLotto() {
        numberOfLotto = new NumberOfLotto(money.money() / LOTTO_PRICE.getPrice());

        return numberOfLotto;
    }
}
