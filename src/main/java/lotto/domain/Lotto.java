package lotto.domain;

import static lotto.utils.ErrorMessages.LOTTO_NUMBER_DUPLICATION;
import static lotto.utils.ErrorMessages.LOTTO_OUT_OF_SIZE;

import java.util.List;

public class Lotto {
    private final List<LottoNumber> lotto;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.lotto = createLotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_OUT_OF_SIZE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != getUniqueSize(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATION);
        }
    }

    private long getUniqueSize(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count();
    }


}
