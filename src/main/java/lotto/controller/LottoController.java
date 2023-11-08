package lotto.controller;

import lotto.Lotto;
import lotto.model.LottoModel;
import lotto.model.LottoPrize;
import lotto.model.LottoResultModel;
import lotto.view.*;

import java.util.List;


public class LottoController {
    LottoModel lottoModel = new LottoModel();
    LottoResultModel lottoResultModel = new LottoResultModel();
    LottoInputView lottoInputView = new LottoInputView();
    LottoWinInputView lottoWinInputView = new LottoWinInputView();
    LottoBuyView lottoBuyView = new LottoBuyView();
    LottoBonusInputView lottoBonusInputView = new LottoBonusInputView();
    LottoResultView lottoResultView = new LottoResultView();

    public void runLotto() {
        int price = lottoInputView.purchasePriceInput();
        lottoModelProcess(price);

        List<Lotto> purchasedLotto = purchaseLotto();
        List<Integer> winNumbers = lottoWinInputView.winNumberInput();
        int bonus = lottoBonusInputView.getBonusInput(winNumbers);

        List<LottoPrize> lottoPrizes = calculatePrizes(purchasedLotto, winNumbers, bonus);
        int[] prizeLog = lottoResultModel.getPrizeLog();

        lottoResultView.printResultLog(prizeLog);
        lottoResultView.printRateOfReturn(lottoPrizes, price);
    }

    private void lottoModelProcess(int price) {
        lottoModel.setInputPrice(price);
        lottoModel.calcPurchasedCount();
    }

    private List<Lotto> purchaseLotto() {
        int count = lottoModel.getPurchasedCount();
        List<Lotto> purchasedLotto = lottoModel.getPurchasedLotto(count);
        lottoBuyView.printPurchaseLog(purchasedLotto, count);
        return purchasedLotto;
    }

    private List<LottoPrize> calculatePrizes(List<Lotto> purchasedLotto, List<Integer> winNumbers, int bonus) {
        lottoResultModel.checkAllLottoMatch(purchasedLotto, winNumbers, bonus);
        return lottoResultModel.getLottoPrizes();
    }
}