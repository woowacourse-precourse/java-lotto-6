package lotto.controller;

import lotto.domain.*;
import lotto.service.*;
import lotto.view.*;

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
