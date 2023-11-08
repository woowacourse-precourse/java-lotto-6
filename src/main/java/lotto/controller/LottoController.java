package lotto.controller;

import lotto.model.Buyer;
import lotto.model.RewardResult;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void start() {
        Buyer buyer = new Buyer(InputView.inputMoney());

        WinningLotto winningLotto = new WinningLotto(
                InputView.inputWinningLottoNumbers(), InputView.inputBonusNumber());

        RewardResult rewardResult = buyer.guessLottery(winningLotto);
        OutputView.printRewardMessage(rewardResult.getRewardResultMessage());
        OutputView.printRateOfReturn(buyer.getRateOfReturn(rewardResult));
    }

    public void end() {
        InputView.close();
    }
}
