package lotto.domain;

import lotto.utils.Validator;

import java.util.HashSet;
import java.util.List;

import static constant.MessageList.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicatedNumbers(numbers);
        for (int number : numbers) {
            validateRangeOfNumber(number);
        }
        this.numbers = numbers;
    }
    public List<Integer> getLottoNumberFromPlayer(){
        return numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != TOTAL_LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_INPUT_HAS_NOT_PROPER_SIZE);
        }
    }

    private void validateDuplicatedNumbers(List<Integer> numbers) {
        HashSet<Integer> lottoNumbersSet = new HashSet<>(numbers);
        if (lottoNumbersSet.size() < numbers.size()) {
            throw new IllegalArgumentException(ERROR_INPUT_HAS_DUPLICATED_NUMBER);
        }
    }

    private void validateRangeOfNumber(int number) {
        if (!(number >= MINIMUM_RANGE_OF_NUMBER && number <= MAXIMUM_RANGE_OF_NUMBER)) {
            throw new IllegalArgumentException(ERROR_INPUT_IS_NOT_IN_PROPER_RANGE);
        }
    }

    // 보너스 번호에 대한 검증
    public int validateBonusNumber(String bonus, List<Integer> numbers) {
        Validator validator = new Validator();
        int bonusNumber = validator.validateNumber(bonus);
        validateRangeOfNumber(bonusNumber);
        validateDuplicateOfWinningNumber(bonusNumber, numbers);
        return bonusNumber;
    }

    private void validateDuplicateOfWinningNumber(int bonusNumber, List<Integer> winningNumber) {
        for (int i = 0; i < winningNumber.size(); i++) {
            if (bonusNumber == winningNumber.get(i)) {
                throw new IllegalArgumentException(ERROR_DUPLICATE_OF_WINNING_NUMBER);
            }
        }
    }
}
