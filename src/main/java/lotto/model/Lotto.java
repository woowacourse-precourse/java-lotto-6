package lotto.model;

import lotto.validation.ErrorMessage;

import java.util.*;

import static lotto.model.constant.LottoConstant.LOTTO_MAX_NUMBER;
import static lotto.model.constant.LottoConstant.LOTTO_MIN_NUMBER;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE_ERROR.getMessage());
        }
    }

    public static void validateDuplication(List<Integer> numbers) {
        Set<Integer> distanceNumbers = new HashSet<>(numbers);
        if(distanceNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATION_ERROR.getMessage());
        }
    }

    public static void validateNumberRange(List<Integer> numbers) {
        List<Integer> sortNumbers = new ArrayList<>(numbers);
        Collections.sort(sortNumbers);
        if(sortNumbers.get(0) < LOTTO_MIN_NUMBER || sortNumbers.get(sortNumbers.size() - 1) > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_RANGE_ERROR.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
