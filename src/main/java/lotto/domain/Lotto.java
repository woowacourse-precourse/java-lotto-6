package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<LottoNumber> numbers) {
        if (isaInvalidLength(numbers) || isDuplicated(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isaInvalidLength(List<LottoNumber> numbers) {
        return numbers.size() != LOTTO_NUMBERS_SIZE;
    }

    private boolean isDuplicated(List<LottoNumber> numbers) {
        if(Set.copyOf(numbers).size() != numbers.size()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers.toArray());
    }
}
