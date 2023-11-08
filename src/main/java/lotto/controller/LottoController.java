package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningNumbers;
import lotto.service.LottoService;
import lotto.service.WinningService;
import lotto.view.InputView;
import lotto.view.ResultView;

/**
 * 로또 게임의 메인 컨트롤러입니다. 사용자의 입력을 받고 게임의 흐름을 제어합니다.
 */
public class LottoController {

    private final LottoService lottoService;
    private final WinningService winningService;

    public LottoController(LottoService lottoService, WinningService winningService) {
        this.lottoService = lottoService;
        this.winningService = winningService;
    }

    public void run() {
        int purchaseAmount = inputPurchaseAmount();
        List<Lotto> lottos = lottoService.createLottoTickets(purchaseAmount);
        WinningNumbers winningNumbers = inputWinningNumbers();
        processWinningNumbers(lottos, winningNumbers, purchaseAmount);
    }

    private int inputPurchaseAmount() {
        return InputView.inputPurchaseAmount();
    }

    private WinningNumbers inputWinningNumbers() {
        return new WinningNumbers(InputView.inputWinningNumbers(), InputView.inputBonusNumber());
    }

    private void processWinningNumbers(List<Lotto> lottos, WinningNumbers winningNumbers,
            int purchaseAmount) {
        Map<LottoRank, Integer> results = winningService.calculateResults(lottos, winningNumbers);
        int totalPrize = winningService.calculateTotalPrize(results);
        double yield = winningService.calculateYield(purchaseAmount, totalPrize);

        ResultView.printWinningResults(results);
        ResultView.printYield(yield);
    }
}
