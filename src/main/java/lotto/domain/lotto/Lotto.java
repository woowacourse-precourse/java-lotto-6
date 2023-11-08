package lotto.domain.lotto;

import java.util.List;
import lotto.domain.validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    Lotto(List<Integer> numbers) {
        LottoValidator.verifyNumbersSize(numbers);
        LottoValidator.verifyNoDuplication(numbers);
        LottoValidator.verifyLottoNumberRange(numbers);
        this.numbers = sort(numbers);
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private List<Integer> sort(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    public List<Integer> getLottoNumbers() {
        return List.copyOf(numbers);
    }
}

