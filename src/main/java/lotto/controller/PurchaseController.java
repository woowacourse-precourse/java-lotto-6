package lotto.controller;

import lotto.domain.lottery.Buyer;
import lotto.domain.lottery.Lottos;
import lotto.dto.LottoNumberResponses;
import lotto.view.PurchaseWriter;

public class PurchaseController {
    private PurchaseController() {
    }

    public static Lottos purchase(final Buyer buyer) {
        Lottos lottos = Lottos.create(buyer);

        LottoNumberResponses lottoResponses =
                LottoNumberResponses.build(buyer, lottos);

        PurchaseWriter.printNewLine();
        PurchaseWriter.printPurchaseCount(lottoResponses);
        PurchaseWriter.printPurchaseLottoNumbers(lottoResponses);

        return lottos;
    }
}
