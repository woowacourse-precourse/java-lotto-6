package lotto.model;

import lotto.config.LottoConstants;
import lotto.view.Messages;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(Messages.LOTTO_NUMBER_SIZE_ERROR_MESSAGE);
        }

        for (int number : numbers) {
            if (number < LottoConstants.LOTTO_MIN_NUMBER.getValue() || number > LottoConstants.LOTTO_MAX_NUMBER.getValue()) {
                throw new IllegalArgumentException(Messages.LOTTO_NUMBER_OUT_OF_RANGE_ERROR_MESSAGE);
            }
        }

        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(Messages.LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE);
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }


}
