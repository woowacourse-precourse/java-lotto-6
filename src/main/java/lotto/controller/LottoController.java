package lotto.controller;

import java.util.List;
import lotto.application.LottoStore;
import lotto.domain.LottoAmount;
import lotto.domain.LottoTicket;
import lotto.dto.WinningLotto;
import lotto.dto.WinningResult;
import lotto.ui.InputView;
import lotto.ui.OutputView;
import lotto.util.StringUtil;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoStore lottoStore;

    public LottoController(final InputView inputView, final OutputView outputView, final LottoStore lottoStore) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoStore = lottoStore;
    }

    public void run() {
        LottoAmount lottoAmount = this.getLottoAmount();
        LottoTicket lottoTicket = this.buyLottoTicket(lottoAmount);
        outputView.printLottoTicket(lottoTicket);
        WinningLotto winningLotto = this.issueWinningLotto();
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
                return lottoStore.issueLottoTicketByAuto(lottoAmount);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private WinningLotto issueWinningLotto() {
        List<Integer> numbers = this.getWinningLottoNumbers();
        while (true) {
            try {
                int bonus = this.getBonusNumber();
                return lottoStore.issueWinningLotto(numbers, bonus);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private List<Integer> getWinningLottoNumbers() {
        while (true) {
            try {
                String input = inputView.scanWinningLottoNumber();
                return StringUtil.convertToIntListByDelimiter(input);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private int getBonusNumber() {
        while (true) {
            try {
                String input = inputView.scanBonusNumber();
                return StringUtil.convertToInt(input);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
