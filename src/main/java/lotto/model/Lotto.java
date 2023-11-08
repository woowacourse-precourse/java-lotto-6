package lotto.model;

import static lotto.util.constants.Numbers.VALID_NUMBER_LIST_SIZE;
import static lotto.util.exception.ErrorMessage.HAS_DUPLICATE_NUMBER;
import static lotto.util.exception.ErrorMessage.NOT_SIX_NUMBERS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    /**
     * Lotto 객체가 매개 변수 정수의 포함 여부 확인 메서드.
     *
     * @param number 포함 여부를 확인하고 싶은 Integer 변수
     * @return 포함되어 있다면 true, 그렇지 않으면 false
     */
    public boolean contains(final Integer number) {
        return numbers.contains(number);
    }

    /**
     * Lotto 객체가 매개 변수 Lotto 객체와 겹치는 번호의 개수를 반환하는 메서드.
     *
     * @param other 확인할 다른 Lotto 객체
     * @return 겹치는 번호의 개수(Integer)
     */
    public Integer countSameNumbers(final Lotto other) {
        return Math.toIntExact(other.numbers.stream()
                .filter(this::contains)
                .count());
    }

    @Override
    public String toString() {
        return numbers.stream()
                .sorted()
                .toList()
                .toString();
    }

    private void validate(final List<Integer> numbers) {
        if (validateListSize(numbers)) {
            throw LottoException.of(NOT_SIX_NUMBERS);
        }

        if (hasDuplicateNumber(numbers)) {
            throw LottoException.of(HAS_DUPLICATE_NUMBER);
        }
    }

    private boolean validateListSize(final List<Integer> numbers) {
        return numbers.size() != VALID_NUMBER_LIST_SIZE.getNumber();
    }

    private boolean hasDuplicateNumber(final List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer number : numbers) {
            if (!set.add(number)) {
                return true;
            }
        }
        return false;
    }
}