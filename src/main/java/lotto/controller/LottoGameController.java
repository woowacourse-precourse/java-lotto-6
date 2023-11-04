package lotto.controller;

import lotto.application.LottoService;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningInfo;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGameController {

    private final LottoService lottoService;

    public LottoGameController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void lottoGame() {
        int input = InputView.readPayMoney();
        Lottos lottos = lottoService.purchaseLottos(Money.of(input));
        OutputView.printMyLotto(lottos);
        List<Integer> winningNumbers = InputView.readWinningNumbers();
        int bonusNumber = InputView.readBonusNumber();
        WinningInfo winningInfo = WinningInfo.from(winningNumbers, bonusNumber);
    }
}
