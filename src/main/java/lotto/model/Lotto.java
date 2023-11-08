package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.ExceptionUtils;
import static lotto.model.Constant.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDup(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6)
            throw new IllegalArgumentException(ExceptionUtils.LOTTO_SIZE_ERROR.getErrorMessage());
    }

    private void validateRange(List<Integer> numbers) {
        List<Integer> valNumbers = new ArrayList<>(numbers);
        Collections.sort(valNumbers);
        if(valNumbers.get(0) < LOTTO_MIN_NUMBER || valNumbers.get(valNumbers.size()-1) > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ExceptionUtils.LOTTO_RANGE_ERROR.getErrorMessage());
        }
    }

    private void validateDup(List<Integer> numbers) {
        Set<Integer> valNumbers = new HashSet<>(numbers);
        if (valNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionUtils.LOTTO_DUP_ERROR.getErrorMessage());
        }
    }

}
