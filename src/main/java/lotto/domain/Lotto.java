package lotto.domain;

import static lotto.util.InputValidator.validateNumberInRange;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.enums.ErrorMessages;
import lotto.enums.GlobalConstant;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers.size());
        for (int number : numbers) {
            validateNumberInRange(number);
        }
        Set<Integer> duplicateRemovedNumbers = makeSetFromNumbers(numbers);
        validateDuplicatedNumber(duplicateRemovedNumbers.size());
    }

    private void validateNumberCount(int numberCount) {
        if (numberCount != GlobalConstant.LOTTO_NUMBER_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.ANSWER_AMOUNT_EXCEPTION_MSG.getMsg());
        }
    }

    private Set<Integer> makeSetFromNumbers(List<Integer> numbers) {
        return new HashSet<>(numbers);
    }

    private void validateDuplicatedNumber(int size) {
        if (size != GlobalConstant.LOTTO_NUMBER_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.ANSWER_DUPLICATED_EXCEPTION_MSG.getMsg());
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public Result compareNumberToAnswer(Answer answer) {
        int hitResult = 0;
        int bonusResult = 0;

        for (int number : numbers) {
            hitResult += searchHitNumbers(answer, number);
            bonusResult += searchBonusNumber(answer, number);
        }

        return new Result(hitResult, bonusResult);
    }

    public boolean findNumber(int number) {
        return numbers.contains(number);
    }

    private int searchHitNumbers(Answer answer, int number) {
        if (answer.isHitNumbersHaveThisNumber(number)) {
            return 1;
        }
        return 0;
    }

    private int searchBonusNumber(Answer answer, int number) {
        if (answer.isBonusNumberTheSameAsThis(number)) {
            return 1;
        }
        return 0;
    }
}
