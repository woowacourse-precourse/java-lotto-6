package lotto;

import java.util.List;
import lotto.config.GameConfig;
import lotto.domain.LottoNumber;
import lotto.util.validator.LottoNumberValidator;

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
        validateRange(numbers);
        validateDuplicateNumber(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != GameConfig.LOTTO_SIZE) {
            throw new IllegalArgumentException(); // TODO: custom 예외 만들기
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != GameConfig.LOTTO_SIZE) {
            throw new IllegalArgumentException(); // TODO: custom 예외 만들기
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.forEach(LottoNumberValidator::validate);
    }
}
