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

    public static LottoRecipe of(Money money) {
        return new LottoRecipe(money);
    }

    public Money getMoney() {
        return money;
    }

    public NumberOfLotto purchaseLotto() {
        return this.numberOfLotto = new NumberOfLotto((int) (money.money() / LOTTO_PRICE.getPrice()));
    }
}
