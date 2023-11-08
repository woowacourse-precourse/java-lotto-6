package lotto.controller;

import lotto.domain.LottoResults;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.view.OutputView;

public class LottoController {

    public void playLotto() {
        Money money = Money.createMoney();
        Lottos lottos = Lottos.createLottos(money);
        OutputView.printLottos(lottos);
        WinningNumbers winningNumbers = WinningNumbers.createWinningNumbers();
        LottoResults lottoResults = LottoResults.createLottoResults(lottos, winningNumbers);
        OutputView.printLottoResults(lottoResults, money);
    }
}
