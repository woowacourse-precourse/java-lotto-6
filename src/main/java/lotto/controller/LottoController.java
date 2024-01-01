package lotto.controller;

import lotto.dto.BonusNumberRequestDto;
import lotto.dto.MoneyRequestDto;
import lotto.dto.WinningNumbersRequestDto;
import lotto.model.LottoMachine;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.WinningLotto;
import lotto.repository.Result;
import lotto.service.LottoService;
import lotto.view.OutputView;
import lotto.view.input.BonusNumberInputView;
import lotto.view.input.MoneyInputView;
import lotto.view.input.WinningNumbersInputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        Money money = toMoney();
        Lottos lottos = toLottos(money);
        WinningLotto winningLotto = toWinningLotto();
        lottoService.run(lottos, winningLotto);
        Result result = lottoService.getResult();
        OutputView.printNumberOfLottoTickets(money);
        OutputView.printRandomLottoTicket(lottos);
        OutputView.printResult(result);
        OutputView.printRateOfReturn(money, result);
    }

    private Money toMoney() {
        while (true) {
            try {
                MoneyRequestDto dto = MoneyInputView.readMoney();
                return new Money(dto.getPrice());
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }

    private Lottos toLottos(Money money) {
        return new Lottos(LottoMachine.buyLottoTickets(money));
    }

    private WinningLotto toWinningLotto() {
        while (true) {
            try {
                WinningNumbersRequestDto winningNumbersRequestDto = WinningNumbersInputView.readWinningNumbers();
                BonusNumberRequestDto bonusNumberRequestDto = BonusNumberInputView.readBonusNumber();
                return new WinningLotto(winningNumbersRequestDto.getNumbers(), bonusNumberRequestDto.getNumber());
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }
}
