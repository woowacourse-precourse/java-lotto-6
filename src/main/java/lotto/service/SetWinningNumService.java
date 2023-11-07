package lotto.service;

import lotto.vo.WinningNumber;

public class SetWinningNumService {
    public WinningNumber generateWinningNumber(String number) {
        return new WinningNumber(number);
    }
}
