package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ClientException;
import lotto.exception.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> mutableNumbers = new ArrayList<>(numbers);
        Collections.sort(mutableNumbers);
        this.numbers = mutableNumbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new ClientException(ExceptionMessage.MESSAGE_LIMIT_SIZE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> validationDuplicate = new HashSet<>(numbers);
        if (numbers.size() != validationDuplicate.size()) {
            throw new ClientException(ExceptionMessage.MESSAGE_DUPLICATE_NUMBER);
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.forEach((number) -> {
            if (number < 1 || 45 < number) {
                throw new ClientException(ExceptionMessage.MESSAGE_RANGE_NUMBER);
            }
        });
    }

    public int countCorrectNumbers(Lotto lotto) {
        int count = 0;
        for (Integer winingNumber : numbers) {
            if (lotto.containNumber(winingNumber)) {
                count++;
            }
        }
        return count;
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }
}
