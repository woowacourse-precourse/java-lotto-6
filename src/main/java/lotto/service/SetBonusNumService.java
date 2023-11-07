package lotto.service;

import lotto.vo.BonusNumber;
import lotto.vo.WinningNumber;

public class SetBonusNumService {
    public BonusNumber generateBonusNum(String number, WinningNumber winningNumber) {
        return new BonusNumber(number,winningNumber);
    }
}
