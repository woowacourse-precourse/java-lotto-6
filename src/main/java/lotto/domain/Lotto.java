package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public int matchWinningNumberCount(List<LottoNumber> compareNumbers) {
        return (int) this.numbers.stream()
                .filter(compareNumbers::contains)
                .count();
    }

    public boolean isMatchBonusNumber(LottoNumber bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers.toArray());
    }

    private void validate(List<LottoNumber> numbers) {
        if (isaInvalidLength(numbers) || isDuplicated(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isaInvalidLength(List<LottoNumber> numbers) {
        return numbers.size() != 6;
    }

    private boolean isDuplicated(List<LottoNumber> numbers) {
        if(Set.copyOf(numbers).size() != numbers.size()) {
            return true;
        }
        return false;
    }
}
