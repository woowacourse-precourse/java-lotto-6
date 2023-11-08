package lotto;

import lotto.domain.MyLotteries;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoRank;
import lotto.util.InputInitializer;
import lotto.util.OutputView;

import java.util.EnumMap;
import java.util.List;

public class LottoController {
    public void play() {
        InputInitializer inputInitializer = new InputInitializer();
        OutputView outputView = new OutputView();

        int purchaseAmount = inputInitializer.inputtingPurchaseAmount();
        List<Lotto> userLotteries = new MyLotteries().BuyLotteries(purchaseAmount);
        outputView.printLotteries(purchaseAmount, userLotteries);

        Lotto winningLotto = inputInitializer.inputtingLottoNumber();
        int bonusNumber = inputInitializer.inputBonusNumber(winningLotto);
        LottoMachine lottoMachine = new LottoMachine(winningLotto, bonusNumber);
        EnumMap<LottoRank, Integer> lottoResultMap = lottoMachine.toLottoResult(userLotteries);
        outputView.printLottoResult(lottoResultMap);
        outputView.printLottoEarningRate(purchaseAmount, lottoResultMap);

    }
}
