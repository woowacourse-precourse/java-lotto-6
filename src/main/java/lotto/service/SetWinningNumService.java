package lotto.service;

import lotto.controller.SetWinningNumController;
import lotto.vo.WinningNumber;

public class SetWinningNumService {
    WinningNumber winningNumber;

    public SetWinningNumService() {
        new SetWinningNumController(this);
    }

    public WinningNumber generateWinningNumber(String number) {
        this.winningNumber = new WinningNumber(number);
        return winningNumber;
    }

    public WinningNumber noticeWinningNumberCompareWinning() {
        return winningNumber;
    }
}
