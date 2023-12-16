package lotto.controller;

import lotto.domain.Lotto;
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
        WinningLotto winningLotto = winningLotto();
        result(money, winningLotto);
    }

    public Money money() {
        Money money = InputView.inputMoney();
        OutputView.printLottoCount(lottoService.insertMoney(money));
        OutputView.print(lottoService.getLottos());
        return money;
    }

    public WinningLotto winningLotto() {
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

    public void result(Money money, WinningLotto winningLotto) {
        OutputView.print(lottoService.getResult(winningLotto));
        OutputView.printPercent(lottoService.getPercent(money));
    }
}
