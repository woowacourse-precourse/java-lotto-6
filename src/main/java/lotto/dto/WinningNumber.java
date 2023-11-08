package lotto.dto;

import java.util.Collections;
import java.util.List;
import lotto.constants.Config;
import lotto.constants.Message;

public record WinningNumber(List<Integer> numbers) {

    public WinningNumber {
        validateNull(numbers);
        validateNumbersCount(numbers.size());
        for (Integer number : numbers) {
            validateNumbersRange(number);
        }
    }

    private void validateNull(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(Message.INPUT_NULL_EXCEPTION);
        }
    }

    private void validateNumbersCount(int size) {
        if (size != Config.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(Message.WINNING_NUMBER_SIZE_EXCEPTION);
        }
    }

    private void validateNumbersRange(Integer number) {
        if (number > Config.MAX_LOTTO_NUMBER || number < Config.MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException(Message.LOTTO_NUMBER_RANGE_EXCEPTION);
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean contains(Integer integer) {
        return numbers.contains(integer);
    }
}
