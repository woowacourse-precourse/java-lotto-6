package lotto.controller;

import lotto.dto.PurchaseAmountRequest;
import lotto.model.Lottos;
import lotto.service.LottoService;
import lotto.view.LottoView;

public class LottoController {

    private final LottoView view;
    private final LottoService service;

    public LottoController(LottoView view, LottoService service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        PurchaseAmountRequest purchaseAmountRequest = view.readPurchaseAmount();
        Lottos lottos = service.makeRandomLottos(purchaseAmountRequest);
        view.writeLottosInfo(lottos.getLottoInfoResponse());
        view.readWinningNumber();
    }
}
