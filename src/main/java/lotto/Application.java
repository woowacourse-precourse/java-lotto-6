package lotto;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoTicketQuantity;
import lotto.model.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

  public static void main(String[] args) {
    LottoTicketQuantity lottoTicketQuantity
        = new LottoTicketQuantity(ControllerService.isValidPurchaseAmount(InputView.getPurchaseAmount()));
    Lottos lottos = new Lottos(lottoTicketQuantity.getLottoTicketQuantity());
    OutputView.announceNumberOfPurchasedTickets(lottoTicketQuantity.getLottoTicketQuantity());
    for (Lotto lotto : lottos.getLottos()) {
      OutputView.displayLottoNumbers(lotto.getNumbers());
    }
    lottos.addLottos(ControllerService.isValidWinningNumber(InputView.getWinningNumber()));
    Lotto lastLotto = lottos.getLottos().get(lottos.getLottos().size() - 1);
    List<Integer> lastLottoNumbers = lastLotto.getNumbers();
    BonusNumber bonusNumber = new BonusNumber(InputView.getBonusNumber(), lastLottoNumbers);
    OutputView.displayWinningStatistics();
    OutputView.resultList(lottos.checkWinningResult(bonusNumber.getBonusNumber()));
    OutputView.displayWinningStatistics(
        lottos.calculateTotalWinningAmount(lottos.checkWinningResult(bonusNumber.getBonusNumber()),
            lottoTicketQuantity.getLottoTicketQuantity()));

  }
}
