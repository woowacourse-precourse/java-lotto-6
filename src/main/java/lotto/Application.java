package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.util.Validator;
import lotto.service.LottoService;
import lotto.ui.ConsoleUI;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Validator validator = new Validator();
        LottoService lottoService = new LottoService();
        ConsoleUI consoleUI = new ConsoleUI(validator);

        final int purchaseAmount = consoleUI    .getPurchaseAmount();
        final List<Lotto> lottoTickets = lottoService.purchaseLotto(purchaseAmount);
        consoleUI.displayLottoNumbers(lottoTickets);
        final List<Integer> winningLottoNumbers = consoleUI.getLottoNumbers();
        final int bonusNumber = consoleUI.getBonusNumber(winningLottoNumbers);
        final Map<LottoResult, Integer> lottoResult = lottoService.calculateResult(lottoTickets, winningLottoNumbers, bonusNumber);
        final double earningsRate = lottoService.getEarningsRate(lottoResult,purchaseAmount);
        consoleUI.displayResult(lottoResult,earningsRate);
    }
}