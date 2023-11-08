package lotto.controller;

import lotto.model.MyLotto;
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
    MyLotto myLotto = lottoService.lotteryIssuance(inputView.readPurchase());
    outputView.printEmptyLine();
    outputView.printPurchasedMessage(myLotto);
    outputView.printPurchasedMyLottoList();

    winningNumber();
  }

  private void winningNumber() {
    WinLotto winLotto = lottoService.setWinningLottery(inputView.readLotteryNumber(), inputView.readBonusNumber());
  }
}
