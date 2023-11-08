package lotto.domain;

import java.util.List;

public class BonusLotto {

    private final String bonusNumber;
    private final List<Integer> winningNumbers;
    public BonusLotto(String bonusNumber, List<Integer> winningNumbers) {
        this.bonusNumber = bonusNumber;
        this.winningNumbers = winningNumbers;
    }
    public int getBonusNumber() {
        return Integer.parseInt(bonusNumber);
    }
}
