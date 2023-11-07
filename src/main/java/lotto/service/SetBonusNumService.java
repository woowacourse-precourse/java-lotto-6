package lotto.service;

import lotto.vo.BonusNumber;
public class SetBonusNumService {
    public BonusNumber generateBonusNum(String number){
        BonusNumber bonusNumber = new BonusNumber(number);
        return bonusNumber;
    }
}
