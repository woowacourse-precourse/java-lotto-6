package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class LottoGameController {

    private BuyLotto buyLotto = new BuyLotto();
    private LottoMachine lottoMachine = new LottoMachine();

    public void playLotto() {
       int purchasePrice = InputView.inputPurchasePrice();
       int purchaseAmount = buyLotto.setPurchasePrice(purchasePrice);

        Lottos lottos = lottoMachine.spinLotto(purchaseAmount);
        OutputView.showLottosNumber(purchaseAmount, lottos);

        String rawWinningNumber = InputView.inputWinningNumber();
        int bonusNumber = InputView.inputBonusNumber();
        PlayerNumber playerNumber = new PlayerNumber(rawWinningNumber, bonusNumber);

        WinningDetails winningDetails = new WinningDetails();
        Map<WinningPrize, Integer> winningStatus = winningDetails.compareWinningNumber(playerNumber.getPlayerNumbers(), lottos.getLottos());

        double earningsRate = buyLotto.calculateEarningsRate(winningStatus, purchasePrice);

        OutputView.printWinningResult(winningStatus, earningsRate);

    }

}
