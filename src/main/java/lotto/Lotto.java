package lotto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.config.GameConfig;
import lotto.domain.LottoNumber;
import lotto.exception.LottoException;
import lotto.exception.LottoGameException;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateLotto(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .toList();
    }

    private void validateLotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicateNumber(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != GameConfig.LOTTO_SIZE) {
            throw new LottoGameException(LottoException.INVALID_SIZE);
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != GameConfig.LOTTO_SIZE) {
            throw new LottoGameException(LottoException.DUPLICATED_NUMBER);
        }
    }

    public boolean contains(LottoNumber number) {
        return this.numbers.contains(number);
    }

    public int countMatchingNumbers(Lotto compare) {
        return (int) compare.numbers.stream()
                .filter(this.numbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return "["
                + numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "))
                + "]";
    }
}
