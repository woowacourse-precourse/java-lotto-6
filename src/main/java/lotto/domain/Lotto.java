package lotto.domain;

import java.util.List;
import lotto.service.LottoGeneratorService;
import lotto.view.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoGeneratorService.MAX_LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_SIZE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LottoGeneratorService.MAX_LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().filter(n -> (n >= LottoGeneratorService.MIN_LOTTO_NUMBER) &&
                (n <= LottoGeneratorService.MAX_LOTTO_NUMBER)).count() != LottoGeneratorService.MAX_LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE);
        }
    }
}
