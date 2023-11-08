package lotto.validator;

import static lotto.constant.MessageConstants.CANNOT_DUPLICATE;
import static lotto.constant.MessageConstants.NUMBER_FORMAT_AND_RANGE;
import static lotto.constant.MessageConstants.WINNING_COUNT;
import static lotto.constant.NumberConstants.LOTTO_NUMBER_MAX;
import static lotto.constant.NumberConstants.LOTTO_NUMBER_MIN;
import static lotto.constant.NumberConstants.LOTTO_NUMBER_SIZE;
import static lotto.constant.NumberConstants.NOT_DIGIT;

import java.util.List;

public class ParserValidator {

    private final List<String> splitNumbers;

    public ParserValidator(List<String> splitNumbers) {
        this.splitNumbers = splitNumbers;
    }

    public void validateAll() {
        validateSize();
        validateNumberCondition();
        validateUnique();
    }

    private void validateSize() {
        if (isWrongSize()) {
            throw new IllegalArgumentException(WINNING_COUNT);
        }
    }

    private boolean isWrongSize() {
        return splitNumbers.size() != LOTTO_NUMBER_SIZE;
    }

    private void validateNumberCondition() {
        splitNumbers.stream()
                .filter(number -> isNotDigit(number) || isWrongRangeNumber(Integer.parseInt(number)))
                .forEach(number -> {
                    throw new IllegalArgumentException(NUMBER_FORMAT_AND_RANGE);
                });
    }

    private boolean isNotDigit(String number) {
        return !number.matches(NOT_DIGIT);
    }

    private boolean isWrongRangeNumber(int number) {
        return (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX);
    }

    private void validateUnique() {
        if (findUniqueNumberCount() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(CANNOT_DUPLICATE);
        }
    }

    private long findUniqueNumberCount() {
        return splitNumbers.stream()
                .distinct()
                .count();
    }

}
