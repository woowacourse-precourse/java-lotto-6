package lotto.controller;

import lotto.dto.LottoResults;
import lotto.model.PurchasePrice;
import lotto.service.BuyLottoService;

public class BuyLottoController {
    private final BuyLottoService buyLottoService;

    public BuyLottoController(BuyLottoService buyLottoService) {
        this.buyLottoService = buyLottoService;
    }

    public LottoResults buyLotto(PurchasePrice purchasePrice) {
        // 로또 구입
        return buyLottoService.buyLotto(purchasePrice);
    }
}
