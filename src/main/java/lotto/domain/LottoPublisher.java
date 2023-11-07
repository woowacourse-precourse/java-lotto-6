package lotto.domain;

import lotto.domain.dto.Purchase;

final class LottoPublisher {

    private final LottoGenerator generator;
    private final LottoController controller;

    public LottoPublisher(LottoGenerator generator, LottoController controller) {
        this.generator = generator;
        this.controller = controller;
    }

    Lottos publish(Money money) {
        Purchase purchase = new LottoStore(new LottoFactory(generator)).sellLottos(money);
        controller.showGeneratedLottos(purchase.numberOfLottos(), purchase.lottos().getLottos());

        return purchase.lottos();
    }
}
