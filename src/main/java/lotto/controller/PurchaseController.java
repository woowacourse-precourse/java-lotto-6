package lotto.controller;

import lotto.domain.lottery.Buyer;
import lotto.domain.lottery.Lottos;
import lotto.dto.LottoNumberResponseAssembler;
import lotto.dto.LottoNumberResponses;
import lotto.view.OutputView;

public class PurchaseController {
    private PurchaseController() {
    }

    public static Lottos purchase(final Buyer buyer) {
        Lottos lottos = Lottos.create(buyer);
        LottoNumberResponses lottoResponses =
                LottoNumberResponseAssembler.createLottoResponses(buyer, lottos);

        OutputView.printPurchaseStatus(lottoResponses);
        return lottos;
    }
}
