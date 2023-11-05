package lotto.core.lotto;

import static lotto.core.enums.LottoNumberEnum.END_VALUE;
import static lotto.core.enums.LottoNumberEnum.START_VALUE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.core.exception.IllegalDuplicateException;
import lotto.core.exception.IllegalLottoRangeException;
import lotto.core.exception.IllegalLottoSizeException;

public record LottoTicket(List<Integer> numbers) {
    public LottoTicket {
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
