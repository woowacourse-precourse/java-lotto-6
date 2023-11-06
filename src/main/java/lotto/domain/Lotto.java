package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.validator.LottoValidator;

import java.util.List;

import static lotto.constants.LottoConstants.NUMBERS_SIZE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public PrizeCondition getPrizeCondition(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        int countMatchingNumbers = countMatchingNumbers(winningNumbers);
        boolean containsBonusNumber = containsBonusNumber(bonusNumber);
        return PrizeCondition.findPrizeCondition(countMatchingNumbers, containsBonusNumber);
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_INVALID_SIZE.getMessage());
        }
        LottoValidator.validateNumbersInRange(numbers);
        LottoValidator.validateDuplicate(numbers);
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
