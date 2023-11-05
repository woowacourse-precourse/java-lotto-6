package lotto.model;

import static lotto.constant.ErrorMessage.DUPLICATE_LOTTO_NUMBER_ERROR_MESSAGE;
import static lotto.constant.ErrorMessage.INVALID_LOTTO_SIZE_ERROR_MESSAGE;
import static lotto.constant.ErrorMessage.LARGER_THAN_MAX_LOTTO_NUMBER_ERROR_MESSAGE;
import static lotto.constant.ErrorMessage.LOWER_THAN_MIN_LOTTO_NUMBER_ERROR_MESSAGE;
import static lotto.constant.LottoInfo.LOTTO_SIZE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.LottoInfo;
import lotto.util.NumberGenerator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE_ERROR_MESSAGE.getMessage());
        }
        if (hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER_ERROR_MESSAGE.getMessage());
        }
        if (hasLargerThanMaxNumber(numbers)) {
            throw new IllegalArgumentException(LARGER_THAN_MAX_LOTTO_NUMBER_ERROR_MESSAGE.getMessage());
        }
        if (hasLessThanMinNumber(numbers)) {
            throw new IllegalArgumentException(LOWER_THAN_MIN_LOTTO_NUMBER_ERROR_MESSAGE.getMessage());
        }
    }

    private boolean hasDuplicateNumber(final List<Integer> numbers) {
        Set<Integer> numberGroup = new HashSet<>(numbers);
        return numbers.size() != numberGroup.size();
    }

    private boolean hasLargerThanMaxNumber(final List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number > LottoInfo.LOTTO_MAX_NUMBER.getValue());
    }

    private boolean hasLessThanMinNumber(final List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < LottoInfo.LOTTO_MIN_NUMBER.getValue());
    }

    public static Lotto createPlayerLotto(final NumberGenerator numberGenerator) {
        return new Lotto(getPlayerLottoNumbers(numberGenerator));
    }

    private static List<Integer> getPlayerLottoNumbers(final NumberGenerator numberGenerator) {
        List<Integer> randomNumbers = numberGenerator.pickNumbers();
        randomNumbers = new ArrayList<>(randomNumbers);
        Collections.sort(randomNumbers);

        return randomNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
