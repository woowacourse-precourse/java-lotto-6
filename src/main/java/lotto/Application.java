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
    lottos.addLottos(InputView.getWinningNumber());
    Lotto lastLotto = lottos.getLottos().get(lottos.getLottos().size() - 1);
    List<Integer> lastLottoNumbers = lastLotto.getNumbers();
    BonusNumber bonusNumber = new BonusNumber(InputView.getBonusNumber(), lastLottoNumbers);
    OutputView.displayWinningStatistics();
    OutputView.resultList(lottos.checkWinningResult(bonusNumber.getBonusNumber()));
    OutputView.displayWinningStatistics(
        lottos.calculateTotalWinningAmount(lottos.checkWinningResult(bonusNumber.getBonusNumber()),
            lottoTicketQuantity.getLottoTicketQuantity()));

  }
//  private static String checkValidPurchaseAmount(String purchaseAmount) {
//    String canPasrse = purchaseAmount;
//    try {
//      // 문자열을 숫자로 변환하여 예외가 발생하지 않으면 숫자로 판단
//      double d = Double.parseDouble(canPasrse);
//    } catch (IllegalArgumentException e) {
//      System.out.println("[ERROR] 구입 금액이 유효하지 않습니다.");
//      checkValidPurchaseAmount(InputView.getPurchaseAmount());
//    }
//    return canPasrse;
//  }
}
