package lotto.application;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {
    public void play() {
        Money money = InputView.inputMoney();
        Lottos lottos = LottoMachine.buyLottos(money);
        ResultView.printTicket(lottos);
        ResultView.showLottoNumbers(lottos);
        Lotto winLotto = InputView.inputWinNumber();
        WinNumber winNumber = InputView.inputBonusNumber(winLotto);
        PrizeResult prizeResult = PrizeResult.from(lottos, winNumber);
        ResultView.showResult(prizeResult);
        ResultView.showReturnRate(prizeResult, money);
    }
}
