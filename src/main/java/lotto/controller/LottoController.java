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
import lotto.util.StringUtil;

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
        WinningLotto winningLotto = new WinningLotto(this.getLotto(), this.getBonus());
        WinningResult winningResult = lottoTicket.match(winningLotto);
        outputView.printWinningResult(winningResult);
        outputView.printYield(winningResult.calculateYield(lottoAmount));
    }

    private LottoAmount getLottoAmount() {
        while (true) {
            try {
                String input = inputView.scanLottoAmount();
                int amount = StringUtil.convertToInt(input);
                return new LottoAmount(amount);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private LottoTicket buyLottoTicket(LottoAmount lottoAmount) {
        while (true) {
            try {
                return lottoMachine.createLottoTicketByAuto(lottoAmount.getLottoQuantity());
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private Lotto getLotto() {
        while (true) {
            try {
                String input = inputView.scanWinningLottoNumber();
                List<Integer> numbers = StringUtil.convertToIntListByDelimiter(input);
                return lottoMachine.createLotto(numbers);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private LottoNumber getBonus() {
        while (true) {
            try {
                String input = inputView.scanBonusNumber();
                int bonus = StringUtil.convertToInt(input);
                return lottoMachine.createLottoNumber(bonus);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
