package lotto.domain;

import static lotto.ErrorMessage.HAS_DUPLICATION_ERROR_MESSAGE;
import static lotto.ErrorMessage.WRONG_RANGE_ERROR_MESSAGE;
import static lotto.ErrorMessage.WRONG_SIZE_ERROR_MESSAGE;
import static lotto.LottoConstance.LOTTO_SIZE;
import static lotto.LottoConstance.MAX_NUMBER_LOTTO_RANGE;
import static lotto.LottoConstance.MIN_NUMBER_LOTTO_RANGE;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = sortNumbers(numbers);
        this.numbers = numbers;
    }

    public boolean has(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (!isLottoSize(numbers)) {
            throwException(WRONG_SIZE_ERROR_MESSAGE.get());
        } else if (!isBetween1to45(numbers)) {
            throwException(WRONG_RANGE_ERROR_MESSAGE.get());
        } else if (hasDuplication(numbers)) {
            throwException(HAS_DUPLICATION_ERROR_MESSAGE.get());
        }
    }

    private boolean isBetween1to45(List<Integer> numbers) {
        return numbers.stream().allMatch(n -> n >= MIN_NUMBER_LOTTO_RANGE.get() && n <= MAX_NUMBER_LOTTO_RANGE.get());
    }

    private boolean hasDuplication(List<Integer> numbers) {
        return numbers.size() > new HashSet<>(numbers).size();
    }

    private boolean isLottoSize(List<Integer> numbers) {
        return numbers.size() == LOTTO_SIZE.get();
    }

    private void throwException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

}
