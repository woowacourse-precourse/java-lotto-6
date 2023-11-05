package lotto.model;

import java.util.List;
import lotto.validation.LottoNumberValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numberSortWithAscendingOrder(numbers);
    }

    private List<Integer> numberSortWithAscendingOrder(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        LottoNumberValidator.validateLottoNumber(numbers);
    }
}
