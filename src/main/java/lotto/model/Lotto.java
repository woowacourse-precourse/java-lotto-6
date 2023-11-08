package lotto.model;

import static lotto.constant.CommonUnits.MAX_LOTTO_NUMBER;
import static lotto.constant.CommonUnits.MIN_LOTTO_NUMBER;
import static lotto.constant.CommonUnits.NUMBERS_OF_LOTTO;
import static lotto.constant.ExceptionMessages.WRONG_NUMBER_BOUND;
import static lotto.constant.ExceptionMessages.WRONG_NUMBER_COUNT;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        isDup(numbers);
        numbers.stream().forEach(this::validateLottoNumber);
    }

    private void validateLottoNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(WRONG_NUMBER_BOUND);
        }
    }

    private List<Integer> isDup(List<Integer> numbers) {
        if (numbers.stream().collect(Collectors.toSet()).size() != NUMBERS_OF_LOTTO) {
            throw new IllegalArgumentException(WRONG_NUMBER_COUNT);
        }
        return numbers;
    }
}
