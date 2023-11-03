package lotto.controller;

import lotto.Lotto;
import lotto.service.PurchaseLottoNumberService;
import lotto.view.NumberOfLottoPurchaseView;

import java.util.List;

public class LottoController {
    private static List<Lotto> purchaseLotto;

    public void run() {
        purchaseLotto();
        setLottoNumber();
        lottoWinningResult();
    }
    private void purchaseLotto() {
        PurchaseLottoNumberService purchaseLottoNumberService = new PurchaseLottoNumberService();
        purchaseLotto = purchaseLottoNumberService.userPurchaseLottoLogic();
    }
    private void setLottoNumber() {

    }
    private void lottoWinningResult() {

    }
}
