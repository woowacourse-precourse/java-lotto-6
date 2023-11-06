package lotto.domain;

import static lotto.domain.enums.Constant.LOTTO_NUMBER_LENGTH;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    private static final String EXCEED_LENGTH_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복이 없어야 합니다.";
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validateLottoNumberLength(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validateLottoNumberLength(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_LENGTH.getConstant()) {
            throw new IllegalArgumentException(EXCEED_LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateDuplicateNumber(final List<Integer> numbers) {
        if (hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }

    private boolean hasDuplicateNumber(final List<Integer> numbers) {
        return (new HashSet<>(numbers).size() != numbers.size());
    }

}
