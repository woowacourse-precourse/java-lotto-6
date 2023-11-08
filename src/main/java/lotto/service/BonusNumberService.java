package lotto.service;

import lotto.model.Bonus;
import lotto.model.WinningNumber;

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
