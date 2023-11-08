package lotto.domain.model.lotto;

import lotto.error.ErrorMessage;
import lotto.config.LottoConfig;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::from)
                .toList();
        return new Lotto(lottoNumbers);
    }

    public int countMatchingNumbers(Lotto winningNumbers) {
        return (int) winningNumbers.numbers
                .stream()
                .filter(this::contains)
                .count();
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<LottoNumber> numbers) {
        if (isSizeDifferent(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DIFFERENT_LOTTO_SIZE.getMessage());
        }

        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }

    }

    private boolean isSizeDifferent(List<LottoNumber> numbers) {
        return numbers.size() != LottoConfig.LOTTO_NUMBERS_SIZE.getValue();
    }

    private boolean hasDuplicates(final List<LottoNumber> numbers) {
        Set<LottoNumber> uniqueNumbers = new HashSet<>(numbers);

        return numbers.size() != uniqueNumbers.size();
    }

}
