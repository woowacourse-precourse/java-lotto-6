package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMoneyPrize;
import lotto.domain.LottoPurchaseAmount;
import lotto.util.CalculateRate;
import lotto.util.MakeLotto;
import lotto.util.MakeLottoCount;
import lotto.view.OutputView;
import lotto.view.OutputViewLotto;
import lotto.view.OutputViewLottoCount;
import lotto.view.OutputViewResult;

import java.util.List;

public class LottoController {
    InputController inputController = new InputController();
    MakeLotto makeLotto = new MakeLotto();

    public void Lotto() {
        LottoPurchaseAmount lottoPurchaseAmount = setPurchaseAmount();

        int lottoCount = MakeLottoCount.getLottoCount(lottoPurchaseAmount.getCount());
        List<Lotto> lottos = makeLotto.makeLottoList(lottoCount);

        OutputViewLottoCount.printLottoCount(lottoCount);
        OutputViewLotto.printLotto(lottos);

        List<Integer> winnerNum = setWinnerNum();

        int bonusNumber = setBonusNum();

        LottoMoneyPrize lottoMoneyPrize = new LottoMoneyPrize(lottos, winnerNum, bonusNumber);
        double rate = CalculateRate.getRate(lottoPurchaseAmount.getCount(), lottoMoneyPrize.getTotalReward());

        setLottoResult(lottoMoneyPrize, rate);


    }

    private LottoPurchaseAmount setPurchaseAmount() {
        return inputController.getPurchaseAmount();
    }

    private List<Integer> setWinnerNum() {
        return inputController.getWinnerNumber();
    }

    private int setBonusNum() {
        return inputController.getBonusNumber();
    }

    private void setLottoResult(LottoMoneyPrize lottoMoneyPrize, double rate) {
        OutputView.printEnter();
        OutputViewResult.printResultStart();
        OutputViewResult.printResultLotto(lottoMoneyPrize.getLottoMoneyPrize());
        OutputViewResult.printResultRate(rate);
    }


}
