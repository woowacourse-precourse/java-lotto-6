package lotto.controller;

import lotto.dto.Result;
import lotto.model.MyLotto;
import lotto.model.WinLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.InputViewImpl;
import lotto.view.OutputView;

public class LottoController {

  private final LottoService lottoService;
  private final InputView inputView;
  private final OutputView outputView;

  public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
    this.lottoService = lottoService;
    this.inputView = inputView;
    this.outputView = outputView;
  }

  public void purchase() {

    MyLotto myLotto;
    do {
      try {
        myLotto = lottoService.lotteryIssuance(inputView.readPurchase());
      } catch (IllegalArgumentException E) {
        outputView.printErrorMessage(E);
        myLotto = null;
      }
    } while (myLotto == null);

    outputView.printEmptyLine();
    outputView.printPurchasedMessage(myLotto);
    outputView.printPurchasedMyLottoList();

    WinLotto winLotto = winningNumber();

    Result result = compareWithWinningNumbers(myLotto, winLotto);
    outputView.printEmptyLine();
    outputView.printWinningStatistics();
    outputView.printSeparator();
    outputView.printWinningStatisticsSummary(result);
  }

  private WinLotto winningNumber() {

    WinLotto winLotto;
    do {
      try {
        winLotto = lottoService.setWinningLottery(inputView.readLotteryNumber(), inputView.readBonusNumber());
      } catch (IllegalArgumentException E) {
        outputView.printErrorMessage(E);
        winLotto = null;
      }
    } while (winLotto == null);

    return winLotto;
  }

  private Result compareWithWinningNumbers(MyLotto myLotto, WinLotto winLotto) {
    return lottoService.getResultFromComparison(myLotto, winLotto);
  }
}
