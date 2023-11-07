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

        //구입금액 입력
        Amount amount = new Amount(inputLottoPurchaseAmount());
        amount.outputLottoPurchaseAmount();

        //구매횟수, 로또 출력
        Lottos lottos = amount.buyLotto();
        lottos.outputLottos();

        //당첨 번호 입력, 보너스 번호 입력
        WinningLotto winningLotto = new WinningLotto(inputWinningLottoNumber(), inputBonusNumber());

        //당첨 통계 계산
        Result result = new Result(lottos, winningLotto);

        //당첨통계
        ResultView.printResult(result);

        //수익률계산
        ResultView.printReward(profitRate(amount, result));
    }

}
