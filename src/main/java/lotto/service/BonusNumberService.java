package lotto.service;

import lotto.model.domain.Bonus;
import lotto.model.domain.WinningNumber;

public class BonusNumberService {
    public Bonus getBonusNumberIfValid(WinningNumber winningNumber, String bonusNumber) {
        try {
            return new Bonus(winningNumber.getNumbers(),bonusNumber);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
