package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static final LottoController instance = new LottoController();

    public static LottoController getInstance() {
        return instance;
    }

    private LottoController() {
    }

    private final LottoService lottoService = LottoService.getInstance();

    public void run() {
        int buyAmount = buyLottoTicket();
        OutputView.printBuyAmount(buyAmount);
        List<Lotto> userLottos = lottoService.getLottoNumbers(buyAmount);
        OutputView.printUserLottos(userLottos);
        List<Integer> winningNumber = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumber);
        Map<Rank, Integer> lottoResult = lottoService.calculateResult(userLottos, winningNumber, bonusNumber);
        OutputView.printLottoResult(lottoResult);
        String revenueRate = lottoService.calculateRevenueRate(buyAmount, lottoResult);
        OutputView.printRevenueRate(revenueRate);
    }

    private int buyLottoTicket() {
        while (true) {
            try {
                OutputView.printBuyPrice();
                return InputView.getBuyAmount();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<Integer> getWinningNumbers() {
        while (true) {
            try {
                OutputView.printRequireMessage();
                return InputView.getWinningNumber();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private int getBonusNumber(List<Integer> winningNumber) {
        while (true) {
            try {
                OutputView.printRequireBonusMessage();
                return InputView.getBonusNumber(winningNumber);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
