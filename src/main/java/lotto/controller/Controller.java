package lotto.controller;

import lotto.dto.BonusNumberRequestDto;
import lotto.dto.MoneyRequestDto;
import lotto.dto.WinningNumbersRequestDto;
import lotto.model.LottoTicket;
import lotto.model.Money;
import lotto.model.RandomLottoTickets;
import lotto.model.WinningLottoTicket;
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
        RandomLottoTickets randomLottoTickets = randomLottos(money);
        WinningLottoTicket winningLottoTicket = winningLotto();
        lottoService.sort(randomLottoTickets, winningLottoTicket);
        OutputView.printNumbersOfLotto(money.numberOfLottos());
        OutputView.printResult(randomLottoTickets.toString());
        OutputView.printResult(lottoService.getResult());
        OutputView.printRateOfReturn(lottoService.getRateOfReturn(money));
    }

    private Money money() {
        while (true) {
            try {
                MoneyRequestDto moneyRequestDto = InputView.inputMoney();
                return new Money(moneyRequestDto.getPrice());
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private RandomLottoTickets randomLottos(Money money) {
        RandomLottoTickets randomLottoTickets = new RandomLottoTickets();
        money.buyLottos(randomLottoTickets);
        return randomLottoTickets;
    }

    private WinningLottoTicket winningLotto() {
        LottoTicket winningNumbers = winningNumber();
        while (true) {
            try {
                BonusNumberRequestDto bonusNumberRequestDto = InputView.inputBonusNumber();
                return new WinningLottoTicket(winningNumbers, bonusNumberRequestDto.getNumber());
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private LottoTicket winningNumber() {
        while (true) {
            try {
                WinningNumbersRequestDto winningNumbersRequestDto = InputView.inputWinningNumbers();
                return new LottoTicket(winningNumbersRequestDto.getNumbers());
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }
}
