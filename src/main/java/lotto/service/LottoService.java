package lotto.service;

import lotto.model.WinningNumber;

public class LottoService {

    private WinningNumber winningNumber;

    public void validateWinningNumber(String winningNumbers) {
        winningNumber = WinningNumber.create(winningNumbers);
    }
}
