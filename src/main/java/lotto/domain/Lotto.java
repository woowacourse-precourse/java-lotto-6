package lotto.domain;

import static lotto.error.ErrorMessage.DUPLICATED_LOTTO_NUMBER;
import static lotto.error.ErrorMessage.INVALID_LOTTO_NUMBER_LENGTH;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class Lotto {
    public static final Integer PRICE = 1000;
    public static final Integer MAX_NUMBER = 45;
    public static final Integer MIN_NUMBER = 1;
    public static final Integer NUMBER_LENGTH = 6;
    private static final String DELIMITER = ", ";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        List<Integer> sortableNumbers = new ArrayList<>(numbers);
        Collections.sort(sortableNumbers);
        this.numbers = sortableNumbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_LENGTH);
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicate(List<Integer> numbers) {
        List<Integer> validateDuplicate = new ArrayList<>();
        for (Integer number : numbers) {
            if (validateDuplicate.contains(number)) {
                throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER);
            }
            validateDuplicate.add(number);
        }
    }

    public Grade grade(List<Integer> winningNumbers, Integer bonusNumber) {
        Integer answer = 0;
        Integer bonus = 0;
        for (Integer number : winningNumbers) {
            if (numbers.contains(number)) {
                answer++;
            }
        }
        if (numbers.contains(bonusNumber)) {
            bonus++;
        }
        return Grade.from(answer, bonus);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(DELIMITER, PREFIX, SUFFIX);
        for (Integer number : numbers) {
            stringJoiner.add(number.toString());
        }
        return stringJoiner.toString();
    }
}
