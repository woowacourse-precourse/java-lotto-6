package lotto.domain;

import java.util.List;

public class WinningNumbers extends Lotto {
    private final int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateLottoRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }


    public int getBonusNumber() {
        return bonusNumber;
    }
}
