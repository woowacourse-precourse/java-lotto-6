package lotto.domain;

import lotto.condition.NumberConditions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.condition.NumberConditions.*;
import static lotto.message.ErrorMessage.DUPLICATION_NUMBER;
import static lotto.message.ErrorMessage.EXCEED_LOTTO_LENGTH;
import static lotto.message.ErrorMessage.NOT_DIVIDED_BY_LOTTO_PRICE;
import static lotto.message.ErrorMessage.NOT_WHOLE_NUMBER;
import static lotto.message.ErrorMessage.OUT_OF_RANGE;

public class LottoValidator {

    public static final int LOTTO_PRICE = 1000;

    public void validateContains(Lotto lotto, int number) {
        if (lotto.containsNumber(number)) {
            throw new IllegalArgumentException(DUPLICATION_NUMBER.getMessage());
        }
    }

    public void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberRange(number);
        }
    }

    public void validateNumberRange(int number) {
        if (number < MIN_NUMBER.getNumber() || number > MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException(OUT_OF_RANGE.getMessage());
        }
    }

    public void validateDivideByLottoPrice(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(NOT_DIVIDED_BY_LOTTO_PRICE.getMessage());
        }
    }

    public void validateDuplicate(List<Integer> numbers) {
        Set<Integer> duplicateRemove = new HashSet<>(numbers);
        if (numbers.size() != duplicateRemove.size()) {
            throw new IllegalArgumentException(DUPLICATION_NUMBER.getMessage());
        }
    }

    public void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException(EXCEED_LOTTO_LENGTH.getMessage());
        }
    }

    public void validateWholeNumber(String number) {
        if (!number.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NOT_WHOLE_NUMBER.getMessage());
        }
    }
}
