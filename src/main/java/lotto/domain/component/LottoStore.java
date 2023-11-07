package lotto.domain.component;

import lotto.domain.constant.Constraint;
import lotto.domain.dto.Purchase;
import lotto.domain.model.Money;

public final class LottoStore {

    private final LottoFactory factory;

    public LottoStore(LottoFactory factory) {
        this.factory = factory;
    }

    public Purchase sellLottos(Money money) {
        int numberOfLotto = money.money() / Constraint.LOTTO_PRICE.getValue();
        return new Purchase(numberOfLotto, factory.createLottos(numberOfLotto));
    }
}
