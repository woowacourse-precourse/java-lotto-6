package lotto.domain;

import static lotto.config.LottoConfig.LOTTO_NUMBER_AMOUNT_MAX;
import static lotto.config.LottoErrorMessage.LOTTO_AMOUNT_MAX_ERROR_MESSAGE;
import static lotto.config.LottoErrorMessage.LOTTO_UNIQUE_ERROR_MESSAGE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortAscending(numbers);
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        if (numbers.size() != LOTTO_NUMBER_AMOUNT_MAX.getValue()) {
            throw new IllegalArgumentException(LOTTO_AMOUNT_MAX_ERROR_MESSAGE.getMessage());
        }

        for (int number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(LOTTO_UNIQUE_ERROR_MESSAGE.getMessage());
            }
        }
    }

    private List<Integer> sortAscending(List<Integer> numbers) {
        try {
            Collections.sort(numbers);
        } catch (UnsupportedOperationException e) {
            List<Integer> mutableNumbers = new ArrayList<>(numbers);
            Collections.sort(mutableNumbers);

            return Collections.unmodifiableList(mutableNumbers);
        }
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
