package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final String INVALID_SIZE_ERROR_MESSAGE = "[ERROR] 로또 숫자는 6개여야 합니다.";
    private static final String INVALID_DISTINCT_ERROR_MESSAGE = "[ERROR] 로또 숫자는 중복되면 안됩니다.";
    public static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = convertLottoNumbers(numbers);
    }

    private List<LottoNumber> convertLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> new LottoNumber(n.toString()))
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        if (isInvalidSize(numbers)) {
            throw new IllegalArgumentException(INVALID_SIZE_ERROR_MESSAGE);
        }
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException(INVALID_DISTINCT_ERROR_MESSAGE);
        }
    }

    private boolean isInvalidSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE;
    }

    private boolean isDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        return set.size() != numbers.size();
    }
}
