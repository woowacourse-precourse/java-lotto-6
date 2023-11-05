package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.validator.LottoNumberValidator;

import java.util.List;

import static lotto.constants.LottoNumberConstants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_INVALID_SIZE.getMessage());
        }

        LottoNumberValidator.validateDuplicate(numbers);
        LottoNumberValidator.validateNumbersInRange(numbers);
    }

    public PrizeCondition getPrizeCondition(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        int countMatchingNumbers = countMatchingNumbers(winningNumbers);
        boolean containsBonusNumber = containsBonusNumber(bonusNumber);
        return PrizeCondition.findPrizeCondition(countMatchingNumbers, containsBonusNumber);
    }

    private int countMatchingNumbers(WinningNumbers comparingNumbers) {
        return (int) numbers.stream()
                .filter(number -> comparingNumbers.getNumbers().contains(number))
                .count();
    }

    private boolean containsBonusNumber(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.getNumber());
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
