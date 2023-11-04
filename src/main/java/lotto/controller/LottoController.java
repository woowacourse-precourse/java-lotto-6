package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputValue;
import lotto.view.OutputValue;

public class LottoController {

    private LottoService lottoService = new LottoService();

    private int lottoCount;

    public LottoController() {
        lottoInit();
        lottoProcess();
        lottoEnd();
    }

    private void lottoInit() {

        OutputValue.purchaseMessage();
        lottoCount = InputValue.getPurchasePrice() / 1000;

        OutputValue.lottoCountMessage(lottoCount);
        lottoService.repeatPurchase(lottoCount);

        for(Lotto lotto : lottoService.getPurchaseLotto()){
            OutputValue.purchaseLottoMessage(lotto.getLotto());
        }

    }

    private void lottoProcess() {

    }

    private void lottoEnd() {

    }
}
