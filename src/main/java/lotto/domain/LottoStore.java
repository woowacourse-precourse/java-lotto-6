package lotto.domain;

final class LottoStore {

    private final LottoFactory factory;

    public LottoStore(LottoFactory factory) {
        this.factory = factory;
    }

    Lottos sellLottos(Money money) {
        int numberOfLotto = money.money() / Constraint.LOTTO_PRICE.getValue();
        return factory.createLottos(numberOfLotto);
    }
}
