package lotto.controller;

import lotto.Lotto;
import lotto.domain.LottoWinningResultDomain;
import lotto.domain.PurchaseLottoNumberDomain;
import lotto.domain.EnterLottoWinningNumbersDomain;

import java.util.List;

public class LottoController {
    private static List<Lotto> purchaseLotto;
    private static List<Integer> winningLottoNumber;

    public void run() {
        purchaseLotto();
        setLottoWinningNumber();
        lottoWinningResult();
    }
    private void purchaseLotto() {
        PurchaseLottoNumberDomain purchaseLottoNumberDomain = new PurchaseLottoNumberDomain();
        purchaseLotto = purchaseLottoNumberDomain.userPurchaseLottoLogic();
    }
    private void setLottoWinningNumber() {
        EnterLottoWinningNumbersDomain setLottoNumberDomain = new EnterLottoWinningNumbersDomain();
        winningLottoNumber = setLottoNumberDomain.userSetWinningNumberLogic();
    }
    private void lottoWinningResult() {
        LottoWinningResultDomain lottoWinningResultDomain = new LottoWinningResultDomain(purchaseLotto, winningLottoNumber);
        lottoWinningResultDomain.lottoWinningResultLogic();
    }
}
