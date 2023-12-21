package lotto.controller;

import lotto.dto.BonusNumberRequestDto;
import lotto.dto.MoneyRequestDto;
import lotto.dto.WinningNumbersRequestDto;
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
                MoneyRequestDto moneyRequestDto = InputView.inputMoney();
                Money money = new Money(moneyRequestDto.getPrice());
                OutputView.printNumbersOfLotto(money.getNumbersOfLotto());
                return money;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
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
                BonusNumberRequestDto bonusNumberRequestDto = InputView.inputBonusNumber();
                return new WinningLotto(winningNumbers, bonusNumberRequestDto.getNumber());
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private Lotto winningNumber() {
        while (true) {
            try {
                WinningNumbersRequestDto winningNumbersRequestDto = InputView.inputWinningNumbers();
                return new Lotto(winningNumbersRequestDto.getNumbers());
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }
}
