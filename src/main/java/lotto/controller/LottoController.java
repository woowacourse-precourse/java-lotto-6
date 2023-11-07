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
        // 1. 구입 금액 입력
        int price = lottoInputView.purchasePriceInput();
        lottoModel.setInputPrice(price);
        lottoModel.calcPurchasedCount();

        // 2. 로또 구매
        int count = lottoModel.getPurchasedCount();
        List<Lotto> purchasedLotto = lottoModel.getPurchasedLotto(count);
        lottoBuyView.printPurchaseLog(purchasedLotto, count);

        // 3. 당첨 번호 입력
        List<Integer> winNumbers = lottoWinInputView.winNumberInput();

        // 4. 보너스 번호 입력
        int bonus = lottoBonusInputView.getBonusInput(winNumbers);

        // 5. 당첨 통계
        lottoResultModel.checkAllLottoMatch(purchasedLotto, winNumbers, bonus);
        List<LottoPrize> lottoPrizes = lottoResultModel.getLottoPrizes();
        int[] prizeLog = lottoResultModel.getPrizeLog();
        lottoResultView.printResultLog(prizeLog);

        // 6.총 수익률 출력
        lottoResultView.printRateOfReturn(lottoPrizes, price);
    }
}