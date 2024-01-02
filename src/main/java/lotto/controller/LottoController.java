package lotto.controller;

import java.util.List;
import java.util.stream.Stream;
import lotto.dto.BonusNumberRequestDto;
import lotto.dto.MoneyRequestDto;
import lotto.dto.WinningNumbersRequestDto;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.WinningLotto;
import lotto.repository.Result;
import lotto.service.LottoService;
import lotto.view.input.BonusNumberInputView;
import lotto.view.input.MoneyInputView;
import lotto.view.input.WinningNumbersInputView;
import lotto.view.output.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        Money money = toMoney();
        WinningLotto winningLotto = toWinningLotto();
        lottoService.run(money, winningLotto);
        List<Lotto> randomLotto = lottoService.getRandomLotto();
        Result result = lottoService.getResult();
        OutputView.printNumberOfLotto(money);
        OutputView.printRandomLotto(randomLotto);
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

    private Lotto toWinningNumbers() {
        while (true) {
            try {
                WinningNumbersRequestDto dto = WinningNumbersInputView.readWinningNumbers();
                return new Lotto(
                        Stream.of(dto.getNumbers())
                                .map(Integer::parseInt)
                                .toList()
                );
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }

    private WinningLotto toWinningLotto() {
        Lotto winningLotto = toWinningNumbers();
        while (true) {
            try {
                BonusNumberRequestDto dto = BonusNumberInputView.readBonusNumber();
                return new WinningLotto(winningLotto, dto.getNumber());
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }
}
