package lotto;

import java.util.HashSet;
import java.util.List;

import static lotto.LottoDetailNumberConstant.*;

public class Lotto {
    private static final String LOTTO_NUMBER_STORE_SIZE_EXCEPTION_MESSAGE = "[ERROR] 로또 번호의 개수는 6개이어야 합니다.";
    private static final String LOTTO_NUMBER_DUPLICATED_EXCEPTION_MESSAGE = "[ERROR] 로또 번호는 중복되지 않는 숫자 이어야 합니다.";
    private static final String LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE = "[ERROR] 로또 번호는 1 ~ 45의 자연수 이어야 합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateLottoNumber(numbers);
        validateRangeLottoNumberLoop(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_STORE_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_STORE_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private void validateDuplicateLottoNumber(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size())
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATED_EXCEPTION_MESSAGE);
    }

    private void validateRangeLottoNumberLoop(List<Integer> numbers) {
        for (int number : numbers) {
            validateRangeLottoNumber(number);
        }
    }

    private void validateRangeLottoNumber(int number) {
        if (!(number >= LOTTO_START_NUMBER && number <= LOTTO_END_NUMBER))
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
