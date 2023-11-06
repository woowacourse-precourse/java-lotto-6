package lotto.domain;

import static java.util.function.Predicate.isEqual;
import static java.util.stream.Collectors.toList;
import static lotto.exception.ExceptionMessage.DUPLICATE_NUMBER_ERROR;
import static lotto.exception.ExceptionMessage.LOTTO_NUMBER_OUT_OF_RANGE;
import static lotto.exception.ExceptionMessage.WINNING_NUMBERS_SIZE_ERROR;
import static lotto.view.NumberConstant.LAST_INDEX_FOR_INSERT_SEPARATOR;
import static lotto.view.NumberConstant.MAXIMUM_LOTTO_NUMBER;
import static lotto.view.NumberConstant.MINIMUM_LOTTO_NUMBER;
import static lotto.view.NumberConstant.VALIDATE_LOTTO_SIZE;
import static lotto.view.NumberConstant.ZERO;
import static lotto.view.SeparatorConstant.LOTTO_NUMBERS_SEPARATOR;

import java.util.List;
import lotto.exception.LottoGameException;

public class Lotto {
    
    private final List<Integer> numbers;
    
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sorted(numbers);
    }
    
    public boolean contains(Integer number) {
        return numbers.stream()
                .anyMatch(isEqual(number));
    }
    
    public long countMatchingWinningNumbers(Lotto anotherLotto) {
        return numbers.stream()
                .filter(anotherLotto::contains)
                .count();
    }
    
    private List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(toList());
    }
    
    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }
    
    private void validateRange(List<Integer> numbers) {
        if (numberOutOfRange(numbers)) {
            throw LottoGameException.from(LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }
    
    private boolean numberOutOfRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(this::isNumberOutOfRange);
    }
    
    private boolean isNumberOutOfRange(int number) {
        return number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER;
    }
    
    private void validateDuplicate(List<Integer> numbers) {
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR.getMessage());
        }
    }
    
    private boolean hasDuplicate(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != VALIDATE_LOTTO_SIZE;
    }
    
    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != VALIDATE_LOTTO_SIZE) {
            throw LottoGameException.from(WINNING_NUMBERS_SIZE_ERROR);
        }
    }
    
    private String appendLottoNumbers() {
        StringBuilder sb = new StringBuilder();
        for (int index = ZERO; index < VALIDATE_LOTTO_SIZE; index++) {
            sb.append(numbers.get(index));
            if (index < LAST_INDEX_FOR_INSERT_SEPARATOR) {
                sb.append(LOTTO_NUMBERS_SEPARATOR);
            }
        }
        return sb.toString();
    }
    
    @Override
    public String toString() {
        return String.format("[%s]", appendLottoNumbers());
    }
}
