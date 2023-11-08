package lotto.controller;

import lotto.dto.PurchaseAmountRequest;
import lotto.model.Lottos;
import lotto.service.LottoMakeService;
import lotto.view.LottoView;

public class LottoController {

    private final LottoView view;
    private final LottoMakeService lottoMakeService;

    public LottoController(LottoView view, LottoMakeService lottoMakeService) {
        this.view = view;
        this.lottoMakeService = lottoMakeService;
    }

    public void run() {
        PurchaseAmountRequest purchaseAmountRequest = view.readPurchaseAmount();
        Lottos lottos = lottoMakeService.makeRandomLottos(purchaseAmountRequest);
        view.writeLottosInfo(lottos.getLottoInfoResponse());
        view.readWinningNumber();
    }
}
