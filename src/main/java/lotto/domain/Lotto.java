package lotto.domain;

import java.util.List;
import lotto.util.Utils;
import lotto.util.Validation;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = Utils.sortListAscending(numbers);
    }

    private void validate(List<Integer> numbers) {
        Validation.validateLottoNumbers(numbers);
    }

    @Override
    public String toString() {
        return String.join(", ", Utils.integerListToStringList(numbers));
    }
}
