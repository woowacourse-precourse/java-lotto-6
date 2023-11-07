package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {

    public static final int LOTTO_PRICE = 1000;

    public void validateContains(Lotto lotto, int number) {
        if (lotto.containsNumber(number)) {
            throw new IllegalArgumentException();
        }
    }

    public void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberRange(number);
        }
    }

    public void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }

    public void validateDivideByLottoPrice(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    public void validateDuplicate(List<Integer> numbers) {
        Set<Integer> duplicateRemove = new HashSet<>(numbers);
        if (numbers.size() != duplicateRemove.size()) {
            throw new IllegalArgumentException();
        }
    }

    public void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
