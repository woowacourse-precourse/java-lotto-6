package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private final LottoService lottoService;

    public Controller(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        Money money = money();
        OutputView.printNumbersOfLotto(money.getNumbersOfLotto());
        Lottos lottos = lottos(money);
        OutputView.print(lottos.toString());
        WinningLotto winningLotto = winningLotto();
        lottoService.calculate(lottos, winningLotto);
        OutputView.print(lottoService.getResult());
        OutputView.printPercent(lottoService.getPercent(money));
    }

    private Money money() {
        return InputView.inputMoney();
    }

    private Lottos lottos(Money money) {
        return new Lottos(money);
    }

    private WinningLotto winningLotto() {
        Lotto winningNumbers = InputView.inputWinningNumbers();
        while (true) {
            try {
                int bonusNumber = InputView.inputBonusNumber();
                return new WinningLotto(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                OutputView.print(e.getMessage());
            }
        }
    }
}
