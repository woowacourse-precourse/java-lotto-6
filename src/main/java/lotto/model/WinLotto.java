package lotto.model;

import static lotto.ErrorMessage.DUPLICATE_WIN_BONUS;

import java.util.List;
import lotto.validator.LottoValidator;

public class WinLotto {
    private final List<Integer> winNumbers;
    private final int bonusNumber;
    public WinLotto(List<Integer> numbers, int bonusNumber) {
        validate(numbers,bonusNumber);
        this.winNumbers=numbers;
        this.bonusNumber=bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        LottoValidator.validateOverSize(numbers);
        LottoValidator.validateDuplicateNumber(numbers);
        LottoValidator.validateNumbersInRange(numbers);
        validateDuplicateBonusNumber(numbers,bonusNumber);
        LottoValidator.validateBonusInRange(bonusNumber);
    }

    private void validateDuplicateBonusNumber(List<Integer> numbers, int bonusNumber){
        if (numbers.stream().anyMatch(num -> num.equals(bonusNumber))) {
            throw new IllegalArgumentException(DUPLICATE_WIN_BONUS.getMessage());
        }
    }
}
