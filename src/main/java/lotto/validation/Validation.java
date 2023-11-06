package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    static final int PAYMENT_UNIT = 1000;
    static final int ZERO = 0;
    static final int LOTTO_MIN = 1;
    static final int LOTTO_MAX = 45;
    static final int LOTTO_SIZE = 6;
    static final String ERROR_MESSAGE_UNIT = "[ERROR] 입력값이 1,000원 단위가 아닙니다.";
    static final String ERROR_MESSAGE_SIZE = "[ERROR] 입력된 숫자가 6개가 아닙니다.";
    static final String ERROR_MESSAGE_RANGE = "[ERROR] 숫자 범위는 1 이상 45 이하여야 합니다.";
    static final String ERROR_MESSAGE_DUPLICATION = "[ERROR] 중복된 숫자가 있습니다.";

    public void validateUnit(int payment) {
        if(payment % PAYMENT_UNIT != ZERO) {
            System.out.println(ERROR_MESSAGE_UNIT);
            throw new IllegalArgumentException(ERROR_MESSAGE_UNIT);
        }
    }

    public void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            System.out.println(ERROR_MESSAGE_SIZE);
            throw new IllegalArgumentException(ERROR_MESSAGE_SIZE);
        }
    }

    public void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if(number < LOTTO_MIN || LOTTO_MAX < number) {
                System.out.println(ERROR_MESSAGE_RANGE);
                throw new IllegalArgumentException(ERROR_MESSAGE_RANGE);
            }
        }
    }

    public void validateDuplication(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if(numbers.size() != uniqueNumbers.size()) {
            System.out.println(ERROR_MESSAGE_DUPLICATION);
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATION);
        }
    }
}