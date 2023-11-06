package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final Integer LOTTO_SIZE = 6;
    private static final String LOTTO_SIZE_ERROR = "[ERROR] 로또 번호 갯수는 6개여야 합니다.";
    private static final String LOTTO_DUPLICATE_ERROR = "[ERROR] 중복되는 숫자는 허용하지 않습니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR);
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> setNumbers = new HashSet<>(numbers);
        if (setNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_DUPLICATE_ERROR);
        }
    }

}
