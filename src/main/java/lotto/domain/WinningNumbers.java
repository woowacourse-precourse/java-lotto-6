package lotto.domain;

import java.util.List;

import lotto.validator.BonusNumberValidator;
import lotto.validator.LottoNumberValidator;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(String winningNumbersInput, int bonusNumber) {
        this.winningNumbers = LottoNumberValidator.convertStringToList(winningNumbersInput);
        this.bonusNumber = BonusNumberValidator.validate(bonusNumber, winningNumbers);
    }

    public boolean matchBonus(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public boolean contains(Integer number) {
        return winningNumbers.contains(number);
    }
}
