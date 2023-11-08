package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import lotto.domain.message.ErrorMessage;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<LottoNumber> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
    }

    private void validateSize(List<LottoNumber> numbers) {

        if (numbers.size() != LottoRule.LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(
                    ErrorMessage.NUMBERS_SIZE_EXCEPTION_MESSAGE.getMessage());
        }
    }

    private void validateDuplication(List<LottoNumber> numbers) {
        if (hasDistinctNumberIn(numbers)) {
            throw new IllegalArgumentException(
                    ErrorMessage.DUPLICATION_EXCEPTION_MESSAGE.getMessage());
        }
    }

    private boolean hasDistinctNumberIn(List<LottoNumber> numbers) {
        return numbers.stream()
                .distinct()
                .toList()
                .size()
                != numbers.size();
    }

    public int calculateMatchCount(Lotto otherLotto) {
        int result = 0;
        for (LottoNumber lottoNumber : numbers) {
            if (otherLotto.hasSameNumber(lottoNumber)) {
                result++;
            }
        }
        return result;
    }

    public boolean hasSameNumber(LottoNumber lottoNumber) {
        return numbers.stream()
                .anyMatch(lottoNumber::equals);
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
