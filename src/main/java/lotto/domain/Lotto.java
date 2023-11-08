package lotto.domain;

import static lotto.util.InputValidator.validateNumberInRange;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.enums.ErrorMessages;
import lotto.enums.GlobalConstant;

public class Lotto {
    private static final int RESULT_INIT_VAL = 0;
    private static final int TRUE_VAL = 1;
    private static final int FALSE_VAL = 0;

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
        int hitResult = RESULT_INIT_VAL;
        int bonusResult = RESULT_INIT_VAL;

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
            return TRUE_VAL;
        }
        return FALSE_VAL;
    }

    private int searchBonusNumber(Answer answer, int number) {
        if (answer.isBonusNumberTheSameAsThis(number)) {
            return TRUE_VAL;
        }
        return FALSE_VAL;
    }
}
