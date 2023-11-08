package lotto;

import lotto.controller.LotteryHost;
import lotto.model.LotteryManager;
import lotto.model.User;
import lotto.model.WinningLotto;
import lotto.utils.GuideMessage;
import lotto.view.Output;

public class
Application {

  public static void main(String[] args) {
    // TODO: 프로그램 구현

    User user = new User();
    LotteryHost lotteryhost = new LotteryHost();
    Output.print(GuideMessage.INPUT_AMOUNT.getMessage());
    try {
      user.buyLotto(lotteryhost.inputLottoCount());
      user.saveLotto(lotteryhost.generateAndSaveLottoTickets(user.getNumberOfLottery()));
      Output.printLottoNumbersAndQuantity(user.getLottoTickets());
      WinningLotto winningLotto = lotteryhost.generateWinningLotto(
          LotteryManager.getWinningLotto(lotteryhost.inputWinningNumbers()),
          LotteryManager.getBonusNumber(lotteryhost.inputBonusNumber()));
      lotteryhost.compareLottoNumbersAndWinningNumbers(user.getLottoTickets(), winningLotto);
      Output.printResult(lotteryhost, user.getNumberOfLottery());
    } catch (IllegalArgumentException e) {
      Output.print(e.getMessage());
    }
  }
}
