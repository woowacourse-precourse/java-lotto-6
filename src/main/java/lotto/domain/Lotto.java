package lotto.domain;

import java.util.List;
import java.util.Objects;

import static lotto.domain.LottoNumberGenerator.MAX_NUMBER;
import static lotto.domain.LottoNumberGenerator.MIN_NUMBER;
import static lotto.domain.LottoNumberGenerator.NUMBERS_SIZE;

public class Lotto {
    private static final String OVER_SIZE_ERROR_MESSAGE = "[ERROR] 총 6개의 숫자로 구성되어야 합니다.";
    private static final String NOT_IN_RIGHT_RANGE_ERROR_MESSAGE = "[ERROR] 각 자릿수는 1 ~ 45 사이의 숫자여야 합니다.";
    private static final String DUPLICATED_NUMBERS_ERROR_MESSAGE = "[ERROR] 중복되는 숫자가 존재합니다.";
    
    private final List<Integer> numbers;
    
    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateNumber(numbers);
        validateDuplicated(numbers);
        this.numbers = numbers;
    }
    
    public List<Integer> getNumbers() {
        return numbers;
    }
    
    public int countMatchingNumber(Lotto otherLotto) {
        return (int) numbers.stream()
                .filter(otherLotto::contains)
                .count();
    }
    
    public boolean contains(int otherNumber) {
        return numbers.contains(otherNumber);
    }
    
    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(OVER_SIZE_ERROR_MESSAGE);
        }
    }
    
    private void validateNumber(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberInSpecifiedRange(number);
        }
    }
    
    public static void validateNumberInSpecifiedRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(NOT_IN_RIGHT_RANGE_ERROR_MESSAGE);
        }
    }
    
    private void validateDuplicated(List<Integer> numbers) {
        if (hasDuplicated(numbers)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBERS_ERROR_MESSAGE);
        }
    }
    
    private boolean hasDuplicated(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
