package lotto.model;

import static lotto.constant.LottoInfo.LOTTO_MAX_NUMBER;
import static lotto.constant.LottoInfo.LOTTO_MIN_NUMBER;
import static lotto.constant.LottoInfo.LOTTO_SIZE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.DuplicateLottoNumberException;
import lotto.exception.ExceedsMaxLottoNumberException;
import lotto.exception.InvalidLottoSizeException;
import lotto.exception.LessThanMinLottoNumberException;
import lotto.util.NumberGenerator;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getValue()) {
            throw new InvalidLottoSizeException();
        }
        if (hasDuplicateNumber(numbers)) {
            throw new DuplicateLottoNumberException();
        }
        if (hasLargerThanMaxNumber(numbers)) {
            throw new ExceedsMaxLottoNumberException();
        }
        if (hasLessThanMinNumber(numbers)) {
            throw new LessThanMinLottoNumberException();
        }
    }

    private boolean hasDuplicateNumber(final List<Integer> numbers) {
        Set<Integer> numberGroup = new HashSet<>(numbers);
        return numbers.size() != numberGroup.size();
    }

    private boolean hasLargerThanMaxNumber(final List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> (number > LOTTO_MAX_NUMBER.getValue()));
    }

    private boolean hasLessThanMinNumber(final List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> (number < LOTTO_MIN_NUMBER.getValue()));
    }

    public static Lotto createPlayerLotto(final NumberGenerator numberGenerator) {
        return new Lotto(getPlayerLottoNumbers(numberGenerator));
    }

    private static List<Integer> getPlayerLottoNumbers(final NumberGenerator numberGenerator) {
        List<Integer> randomNumbers = numberGenerator.pickNumbers();
        randomNumbers = new ArrayList<>(randomNumbers);
        Collections.sort(randomNumbers);

        return Collections.unmodifiableList(randomNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
