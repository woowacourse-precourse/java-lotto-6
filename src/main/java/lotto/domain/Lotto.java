package lotto.domain;
import static java.util.Collections.*;
import static lotto.utils.LottoValidateUtils.*;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validateLottoNumbers(numbers);
        this.numbers = numbers.stream()
            .sorted()
            .toList();
    }

    public List<Integer> getNumbers() {
        return unmodifiableList(numbers);
    }
}
