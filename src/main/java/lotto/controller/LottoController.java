package lotto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

/**
 * 로또 게임의 메인 컨트롤러입니다. 사용자의 입력을 받고 게임의 흐름을 제어합니다.
 */
public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        int purchaseAmount = inputPurchaseAmount();
        List<Lotto> lottos = createLottoTickets(purchaseAmount);
        WinningNumbers winningNumbers = inputWinningNumbers();
        displayResults(lottos, winningNumbers);
    }

    private int inputPurchaseAmount() {
        return InputView.inputPurchaseAmount();
    }

    private List<Lotto> createLottoTickets(int purchaseAmount) {
        int ticketCount = lottoService.calculateNumberOfLottoTickets(purchaseAmount);
        List<Lotto> lottos = lottoService.generateLottos(ticketCount);
        ResultView.printPurchasedLottos(lottos);
        return lottos;
    }

    private WinningNumbers inputWinningNumbers() {
        return new WinningNumbers(InputView.inputWinningNumbers(), InputView.inputBonusNumber());
    }

    private void displayResults(List<Lotto> lottos, WinningNumbers winningNumbers) {
        Map<LottoRank, Integer> results = new HashMap<>();
        for (Lotto lotto : lottos) {
            int matchCount = winningNumbers.matchCount(lotto);
            boolean matchBonusNumber = winningNumbers.matchBonusNumber(lotto);
            LottoRank lottoRank = LottoRank.valueOf(matchCount, matchBonusNumber);
            results.put(lottoRank, results.getOrDefault(lottoRank, 0) + 1);
        }
        ResultView.printWinningResults(results);
    }
}
