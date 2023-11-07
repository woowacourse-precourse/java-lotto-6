package lotto.controller.inputController;

import lotto.view.inputView.LottoWinningNumberInput;
import lotto.model.lottoResultChecker.Lotto;


public class LottoWinningNumberController {
    private final LottoWinningNumberInput winningNumberInput;

    public LottoWinningNumberController() {
        this.winningNumberInput = new LottoWinningNumberInput();
    }

    public Lotto receiveAndCreateLotto() {
        String input = winningNumberInput.requestWinningNumbers();
        return new Lotto(input);
    }
}