package lotto.controller;

import lotto.dto.BonusNumberForm;
import lotto.dto.MoneyForm;
import lotto.dto.WinningNumbersForm;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.RandomLottos;
import lotto.model.WinningLotto;
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
        RandomLottos randomLottos = randomLottos(money);
        WinningLotto winningLotto = winningLotto();
        lottoService.calculate(randomLottos, winningLotto);
        OutputView.print(lottoService.getResult());
        OutputView.printPercent(lottoService.getPercent(money));
    }

    private Money money() {
        while (true) {
            try {
                MoneyForm moneyForm = InputView.inputMoney();
                Money money = new Money(moneyForm.getPrice());
                OutputView.printNumbersOfLotto(money.getNumbersOfLotto());
                return money;
            } catch (IllegalArgumentException e) {
                OutputView.print(e.getMessage());
            }
        }
    }

    private RandomLottos randomLottos(Money money) {
        RandomLottos randomLottos = new RandomLottos(money);
        OutputView.print(randomLottos.toString());
        return randomLottos;
    }

    private WinningLotto winningLotto() {
        Lotto winningNumbers = winningNumber();
        while (true) {
            try {
                BonusNumberForm bonusNumberForm = InputView.inputBonusNumber();
                return new WinningLotto(winningNumbers, bonusNumberForm.getNumber());
            } catch (IllegalArgumentException e) {
                OutputView.print(e.getMessage());
            }
        }
    }

    private Lotto winningNumber() {
        while (true) {
            try {
                WinningNumbersForm winningNumbersForm = InputView.inputWinningNumbers();
                return new Lotto(winningNumbersForm.getNumbers());
            } catch (IllegalArgumentException e) {
                OutputView.print(e.getMessage());
            }
        }
    }
}
