package lotto.model;

import java.util.List;

public class Checker {
    private Lotto winningNumbers;
    private int bonusNumber;

    public Checker(Lotto winningNumbers, int bonusNumber) {
        this.duplicateTestLottoWithBonus(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void duplicateTestLottoWithBonus(Lotto winningNumbers, int bonusNumber) {
        for (int number : Lotto.getNumbers()) {
            if (number == bonusNumber) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 중복되지 않는 로또 번호여야 합니다.");
            }
        }
    }
}
