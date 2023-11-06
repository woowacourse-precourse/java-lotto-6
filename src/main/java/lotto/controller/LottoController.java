package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.application.LottoMachine;
import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.dto.WinningLotto;
import lotto.dto.WinningResult;
import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.util.Converter;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public LottoController(final InputView inputView, final OutputView outputView, final LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        LottoAmount lottoAmount = this.getLottoAmount();
        LottoTicket lottoTicket = this.buyLottoTicket(lottoAmount);
        outputView.printLottoTicket(lottoTicket);

        WinningLotto winningLotto = this.getWinningLotto();
        WinningResult winningResult = lottoTicket.match(winningLotto);
        outputView.printWinningResult(winningResult);
        outputView.printYield(winningResult.calculateYield(lottoAmount));
    }

    private LottoAmount getLottoAmount() {
        return this.inputWithRetry(() -> {
            String input = inputView.scanLottoAmount();
            int amount = Converter.convertToInt(input);
            return new LottoAmount(amount);
        });
    }

    private LottoTicket buyLottoTicket(LottoAmount lottoAmount) {
        int quantity = lottoAmount.getLottoQuantity();
        return lottoMachine.createLottoTicketByAuto(quantity);
    }

    private WinningLotto getWinningLotto() {
        Lotto lotto = this.getLotto();
        return this.inputWithRetry(() -> {
            LottoNumber bonus = getBonus();
            return new WinningLotto(lotto, bonus);
        });
    }

    private Lotto getLotto() {
        return this.inputWithRetry(() -> {
            String input = inputView.scanWinningLottoNumber();
            List<Integer> numbers = Converter.convertToIntListByDelimiter(input);
            return lottoMachine.createLotto(numbers);
        });
    }

    private LottoNumber getBonus() {
        String input = inputView.scanBonusNumber();
        int bonus = Converter.convertToInt(input);
        return lottoMachine.createLottoNumber(bonus);
    }

    private <T> T inputWithRetry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
