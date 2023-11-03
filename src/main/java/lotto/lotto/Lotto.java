package lotto.lotto;

import static lotto.enums.LottoNumberEnum.END_VALUE;
import static lotto.enums.LottoNumberEnum.START_VALUE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.IllegalDuplicateException;
import lotto.exception.IllegalLottoRangeException;
import lotto.exception.IllegalLottoSizeException;

public record Lotto(List<Integer> numbers) {
    public Lotto {
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateNumberRange(numbers);
        validateNumberIsDuplicate(numbers);
    }

    private static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalLottoSizeException();
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < START_VALUE.getValue() || number > END_VALUE.getValue()) {
                throw new IllegalLottoRangeException();
            }
        }
    }

    private static void validateNumberIsDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalDuplicateException();
            }
        }
    }

    @Override
    public List<Integer> numbers() {
        return new ArrayList<>(numbers);
    }

}
