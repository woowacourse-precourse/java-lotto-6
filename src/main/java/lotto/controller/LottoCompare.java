package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import lotto.service.LottoCompareService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoCompare {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void access(Lottos lottos) {
        outputView.printInputWinningNumbersMessage();
        WinningNumber winningNumber = inputView.readWinningNumber();
        outputView.printInputBonusNumberMessage();
        winningNumber.addBonusNumber(inputView.readBonusNumber());
        compare(lottos, winningNumber);
    }

    private void compare(Lottos lottos, WinningNumber winningNumber) {
        LottoCompareService service = new LottoCompareService(lottos, winningNumber);
        service.compareLottosToWinningNumber();
    }
}
