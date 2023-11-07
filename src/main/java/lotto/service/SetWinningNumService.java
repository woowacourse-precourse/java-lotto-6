package lotto.service;

import lotto.vo.WinningNumber;

public class SetWinningNumService {
    public WinningNumber generateWinningNumber(String number) {
        WinningNumber winningNumber = new WinningNumber(number);
        return winningNumber;
    }
}
