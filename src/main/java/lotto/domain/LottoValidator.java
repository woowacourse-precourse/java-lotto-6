package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.message.ErrorMessage.DUPLICATION_NUMBER;
import static lotto.message.ErrorMessage.EXCEED_LOTTO_LENGTH;
import static lotto.message.ErrorMessage.NOT_DIVIDED_BY_LOTTO_PRICE;
import static lotto.message.ErrorMessage.NOT_WHOLE_NUMBER;
import static lotto.message.ErrorMessage.OUT_OF_RANGE;

public class LottoValidator {

    public static final int LOTTO_PRICE = 1000;

    public void validateContains(Lotto lotto, int number) throws IllegalArgumentException {
        if (lotto.containsNumber(number)) {
            throw new IllegalArgumentException(DUPLICATION_NUMBER.getMessage());
        }
    }

    public void validateNumbersRange(List<Integer> numbers) throws IllegalArgumentException {
        for (int number : numbers) {
            validateNumberRange(number);
        }
    }

    public void validateNumberRange(int number) throws IllegalArgumentException {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(OUT_OF_RANGE.getMessage());
        }
    }

    public void validateDivideByLottoPrice(int amount) throws IllegalArgumentException {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(NOT_DIVIDED_BY_LOTTO_PRICE.getMessage());
        }
    }

    public void validateDuplicate(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> duplicateRemove = new HashSet<>(numbers);
        if (numbers.size() != duplicateRemove.size()) {
            throw new IllegalArgumentException(DUPLICATION_NUMBER.getMessage());
        }
    }

    public void validateSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(EXCEED_LOTTO_LENGTH.getMessage());
        }
    }

    public void validateWholeNumber(String number) throws IllegalArgumentException {
        if (!number.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NOT_WHOLE_NUMBER.getMessage());
        }
    }
}
