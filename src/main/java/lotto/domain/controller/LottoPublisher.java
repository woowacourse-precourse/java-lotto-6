package lotto.domain.controller;

import lotto.domain.component.LottoFactory;
import lotto.domain.LottoGenerator;
import lotto.domain.component.LottoStore;
import lotto.domain.dto.Purchase;
import lotto.domain.model.Lottos;
import lotto.domain.model.Money;

public final class LottoPublisher {

    private final LottoGenerator generator;
    private final LottoController controller;

    public LottoPublisher(LottoGenerator generator, LottoController controller) {
        this.generator = generator;
        this.controller = controller;
    }

    public Lottos publish(Money money) {
        Purchase purchase = new LottoStore(new LottoFactory(generator)).sellLottos(money);
        controller.showGeneratedLottos(purchase.numberOfLottos(), purchase.lottos().getLottos());

        return purchase.lottos();
    }
}
