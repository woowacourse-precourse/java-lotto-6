package lotto.domain.winningnumber;

import java.util.List;

import lotto.domain.Lotto;
import lotto.validator.LottoNumberValidator;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(String winningNumbersInput, int bonusNumber) {
        this.winningNumbers = LottoNumberValidator.convertStringToList(winningNumbersInput);
        this.bonusNumber = bonusNumber;
    }

    public boolean matchBonus(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public boolean contains(Integer number) {
        return winningNumbers.contains(number);
    }
}
