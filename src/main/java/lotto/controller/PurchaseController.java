package lotto.controller;

import lotto.domain.lottery.Buyer;
import lotto.domain.lottery.Lottos;
import lotto.dto.LottoNumberResponses;
import lotto.view.OutputView;

public class PurchaseController {
    private PurchaseController() {
    }

    public static Lottos purchase(final Buyer buyer) {
        Lottos lottos = Lottos.create(buyer);

        LottoNumberResponses lottoResponses =
                LottoNumberResponses.build(buyer, lottos);

        OutputView.printNewLine();
        OutputView.printPurchaseCount(lottoResponses);
        OutputView.printPurchaseLottoNumbers(lottoResponses);

        return lottos;
    }
}
