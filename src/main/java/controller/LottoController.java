package controller;

import static service.ProfitRate.profitRate;
import static view.InputView.inputBonusNumber;
import static view.InputView.inputLottoPurchaseAmount;
import static view.InputView.inputWinningLottoNumber;


import domain.Amount;
import domain.Lottos;
import domain.Result;
import domain.WinningLotto;
import view.ResultView;


public class LottoController {
    public void start() {
        Amount amount = inputLottoPurchaseAmount();
        amount.outputLottoPurchaseAmount();
        Lottos lottos = amount.buyLotto();
        lottos.outputLottos();
        WinningLotto winningLotto = new WinningLotto(inputWinningLottoNumber(), inputBonusNumber());
        Result result = new Result(lottos, winningLotto);
        ResultView.printResult(result);
        ResultView.printReward(profitRate(amount, result));
    }

}
