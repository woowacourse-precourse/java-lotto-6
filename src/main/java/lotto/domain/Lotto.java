package lotto.domain;

import static lotto.global.Configuration.MAXIMUM_RANGE_VALUE;
import static lotto.global.Configuration.MINIMUM_RANGE_VALUE;
import static lotto.global.Configuration.PICK_COUNT;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import lotto.util.ConvertingUtil;
import lotto.util.LottoMaker;

public class Lotto {
    private final List<Integer> numbers;

    public static Lotto create() {
        return new Lotto();
    }

    public static Lotto create(String userNumbers) {
        List<Integer> numbers = Arrays.stream(userNumbers.split(","))
                .map(ConvertingUtil::convertToInteger)
                .toList();

        return new Lotto(numbers);
    }

    //computer's Lotto constructor
    private Lotto() {
        this.numbers = LottoMaker.generate();
    }

    //user's Lotto constructor
    private Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateRange(numbers);
        validateDuplication(numbers);

        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) {
        if (isValidLength(numbers)) {
            throw new LottoException(ErrorMessage.NOT_REQUIRED_LENGTH);
        }
    }

    private boolean isValidLength(List<Integer> numbers) {
        return numbers.size() != PICK_COUNT.getValue();
    }

    private void validateDuplication(List<Integer> numbers) {
        if (hasDuplicatedNumber(numbers)) {
            throw new LottoException(ErrorMessage.HAS_DUPLICATION);
        }
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        return numbers.size() != new HashSet<Integer>(numbers).size();
    }

    private void validateRange(List<Integer> numbers) {
        if (isNotRequiredRange(numbers)) {
            throw new LottoException(ErrorMessage.OUT_OF_RANGE);
        }
    }

    private boolean isNotRequiredRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < MINIMUM_RANGE_VALUE.getValue() || number > MAXIMUM_RANGE_VALUE.getValue());
    }

    public List<Integer> getLottoNumbers() {
        return List.copyOf(numbers);
    }

    public boolean contain(int number) {
        return numbers.contains(number);
    }
}
