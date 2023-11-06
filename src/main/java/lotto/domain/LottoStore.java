package lotto.domain;

import lotto.domain.dto.Purchase;

final class LottoStore {

    private final LottoFactory factory;

    public LottoStore(LottoFactory factory) {
        this.factory = factory;
    }

    Purchase sellLottos(Money money) {
        Integer numberOfLotto = money.money() / Constraint.LOTTO_PRICE.getValue();
        return new Purchase(numberOfLotto, factory.createLottos(numberOfLotto));
    }
}
