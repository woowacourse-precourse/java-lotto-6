package lotto.domain;

import lotto.domain.dto.PurchaseDTO;

final class LottoStore {

    private final LottoFactory factory;

    public LottoStore(LottoFactory factory) {
        this.factory = factory;
    }

    PurchaseDTO sellLottos(Money money) {
        Integer numberOfLotto = money.money() / Constraint.LOTTO_PRICE.getValue();
        return new PurchaseDTO(numberOfLotto, factory.createLottos(numberOfLotto));
    }
}
