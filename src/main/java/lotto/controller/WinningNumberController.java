package lotto.controller;

import lotto.view.LottoWinningNumberInput;
import java.util.List;

public class WinningNumberController {

    private final LottoWinningNumberInput winningNumberInput;

    public WinningNumberController() {
        this.winningNumberInput = new LottoWinningNumberInput();
    }

    public List<Integer> getWinningNumbers() {
        return winningNumberInput.requestWinningNumbers();
    }
}
