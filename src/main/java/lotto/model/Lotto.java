package lotto.model;

import static lotto.model.LottoRule.MAXIMUM_NUMBER;
import static lotto.model.LottoRule.MINIMUM_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoNumberDuplicateException;
import lotto.exception.LottoNumberSizeException;
import lotto.exception.LottoNumericRangeException;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateNumericRange(numbers);

        this.numbers = numbers;
    }

    /**
     * 로또 번호 길이에 대한 검증
     *
     * @param numbers
     */
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoNumberSizeException();
        }
    }

    /**
     * 중복된 숫자가 있는지 검사한다.
     *
     * @param numbers 검사할 Integer List
     */
    private void validateDuplicate(List<Integer> numbers) {
        // 중복을 허용하지 않는 Set 자료구조를 사용한다.
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbersSet.size() != numbers.size()) { // 크기를 비교한다.
            throw new LottoNumberDuplicateException();
        }
    }

    /**
     * 1 ~ 45까지의 숫자를 가지는지 검증한다.
     *
     * @param numbers
     */
    private void validateNumericRange(List<Integer> numbers) {
        for (int num :
                numbers) {
            if (num < MINIMUM_NUMBER || num > MAXIMUM_NUMBER) {
                throw new LottoNumericRangeException();
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
