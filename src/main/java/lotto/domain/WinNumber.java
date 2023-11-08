package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.validator.LottoNumberValidator;

public class WinNumber {
    private final Set<Integer> numbers;
    private final int bonusNumber;

    public WinNumber(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        this.numbers = new HashSet<>(numbers);
        this.bonusNumber = bonusNumber;
    }

    public Set<Integer> getNumbers() {
        return this.numbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        LottoNumberValidator.validateLottoNumbers(numbers);
        LottoNumberValidator.validateDuplicatedNumber(numbers, bonusNumber);
        LottoNumberValidator.validateSingleNumberRange(bonusNumber);
    }
}
