package lotto.domain;

import static lotto.utils.ValueUnit.END_NUMBER;
import static lotto.utils.ValueUnit.LOTTO_NUMBERS;
import static lotto.utils.ValueUnit.START_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.OutOfRangeNumbersException;
import lotto.exception.WrongSameNumberException;
import lotto.utils.ValueUnit;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkSameNumbers(numbers);
        checkNumbersInRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Integer lottoNumbers = LOTTO_NUMBERS.getValue();
        if (numbers.size() != lottoNumbers) {
            throw new IllegalArgumentException();
        }
    }

    private void checkSameNumbers(List<Integer> numbers) {
        Set<Integer> comparisonTarget = new HashSet<>(numbers);
        Integer lottoNumbers = LOTTO_NUMBERS.getValue();
        if (comparisonTarget.size() != lottoNumbers) {
            throw new WrongSameNumberException();
        }
    }

    private void checkNumbersInRange(List<Integer> numbers) {
        numbers.stream()
                .filter(this::isInRangeOneToFortyFive)
                .findAny()
                .ifPresent(number -> {
                    throw new OutOfRangeNumbersException();
                });
    }

    private boolean isInRangeOneToFortyFive(Integer number) {
        Integer startNumber = START_NUMBER.getValue();
        Integer endNumber = END_NUMBER.getValue();
        return number < startNumber|| number > endNumber;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    public boolean isContainBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
