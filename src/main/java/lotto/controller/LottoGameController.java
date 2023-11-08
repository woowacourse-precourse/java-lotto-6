package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.PrizeResult;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    public void startGame() {
        Money money = Money.from(InputView.inputAmount());
        OutputView.printLottoCountMessage(money.getLottoCount());

        Lottos lottos = Lottos.createByGenerator(money.getLottoCount());
        OutputView.printLottoNumbers(lottos.getLottoNumbers());

        WinningLotto winningLotto = WinningLotto.of(InputView.inputWinningNumber(),
                InputView.inputBonusNumber());

        PrizeResult prizeResult = PrizeResult.of(lottos, winningLotto);
        OutputView.printResults(prizeResult.getResults(), money.getProfit(prizeResult.getPrizeMoney()));
    }
}
