package lotto.service;

import lotto.model.domain.Bonus;
import lotto.model.domain.WinningLotto;

public class BonusNumberService {
    public Bonus getBonusNumberIfValid(WinningLotto winningLotto, String bonusNumber) {
        try {
            return new Bonus(winningLotto.getNumbers(),bonusNumber);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
