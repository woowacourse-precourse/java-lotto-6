package lotto.model;

import lotto.constant.IntConstants;
import lotto.constant.StringConstants;
import lotto.message.ExceptionMessage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(String numbersInput) {
        List<Integer> numbers = convertStringToIntList(numbersInput);
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> convertStringToIntList(String numbersInput) {
        List<String> number = splitBySeparator(numbersInput);
        try {
            return number.stream().map(Integer::parseInt).toList();
        } catch (NumberFormatException ex) {
            ExceptionMessage.INPUT_NOT_NUMBER_MESSAGE.throwException();
        }
        return Collections.emptyList();
    }

    private List<String> splitBySeparator(String numbers) {
        String BLANK = StringConstants.BLANK.getValue();
        String EMPTY = StringConstants.EMPTY.getValue();
        String LOTTO_SEPARATOR = StringConstants.LOTTO_SEPARATOR.getValue();
        return Arrays.stream(numbers.replace(BLANK, EMPTY).split(LOTTO_SEPARATOR)).toList();
    }

    private void validate(List<Integer> numbers) {
        consistOfLottoSize(numbers);
        isInRange(numbers);
        isNotDuplicated(numbers);
    }

    private void consistOfLottoSize(List<Integer> numbers) {
        if (numbers.size() != IntConstants.LOTTO_SIZE.getValue()) {
            ExceptionMessage.NOT_SAME_WITH_LOTTO_SIZE.throwException(IntConstants.LOTTO_SIZE.getValue());
        }
    }

    private void isInRange(List<Integer> numbers) {
        int minLottoNumber = IntConstants.MIN_LOTTO_NUMBER.getValue();
        int maxLottoNumber = IntConstants.MAX_LOTTO_NUMBER.getValue();
        boolean isInRangeValue = numbers.stream().allMatch(number -> number >= minLottoNumber && number <= maxLottoNumber);
        if (!isInRangeValue) {
            ExceptionMessage.IS_NOT_IN_RANGE.throwException(minLottoNumber, maxLottoNumber);
        }
    }

    private void isNotDuplicated(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            ExceptionMessage.CONSIST_OF_DUPLICATE_NUMBER.throwException();
        }
    }
}
