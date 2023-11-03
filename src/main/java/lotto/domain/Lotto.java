package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.validation.LottoNumberValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoNumberValidator.validateLottoNumberSize(numbers);
        LottoNumberValidator.validateLottoNumberRange(numbers);
        LottoNumberValidator.validateLottoNumberDuplication(numbers);
        this.numbers = numbers.stream().sorted().collect(Collectors.toList());;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
