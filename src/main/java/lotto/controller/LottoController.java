package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
  private final InputView inputView;
  private final OutputView outputView;

  private LottoController(InputView inputView, OutputView outputView) {
    this.inputView = inputView;
    this.outputView = outputView;
  }

  public static LottoController of(InputView inputView, OutputView outputView) {
    return new LottoController(inputView, outputView);
  }
}
