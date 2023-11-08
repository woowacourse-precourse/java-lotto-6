package lotto.service;

import lotto.vo.BonusNumber;
import lotto.vo.WinningNumber;

public class SetBonusNumService {

    BonusNumber bonusNumber;
    public BonusNumber generateBonusNum(String number, WinningNumber winningNumber) {
        this.bonusNumber = new BonusNumber(number,winningNumber);
        return bonusNumber;
    }

    public BonusNumber noticeBonusNumberForCompareWinning(){
        return bonusNumber;
    }
}
