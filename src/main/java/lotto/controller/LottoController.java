package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningLottoNumbers;
import lotto.service.LottoGenerationService;
import lotto.service.LottoWinningService;
import lotto.service.ProfitCalculationService;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class LottoController {

  public void runLottoGame() {
    LottoGenerationService lottoGenerationService = new LottoGenerationService();
    LottoWinningService lottoWinningService = new LottoWinningService();
    ProfitCalculationService profitCalculationService = new ProfitCalculationService();

    int ticket = Input.getPurchaseAmount();
    Output.printPurchasedLottoCount(ticket);

    List<Lotto> userLottoList = lottoGenerationService.generateLottoTickets(ticket);
    Output.printGeneratedLottoNumbers(userLottoList);

    WinningLottoNumbers winningNumbers = new WinningLottoNumbers(Input.getWinningNumbers(), Input.getBonusNumber());

    List<Integer> winningResults = lottoWinningService.checkWinningResults(userLottoList, winningNumbers);
    Output.printResult(winningResults);
    Output.printProfitRate(profitCalculationService.calculateProfitRate(ticket, winningResults));
  }
}
