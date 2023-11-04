package lotto.domain;
import static java.util.Collections.*;
import static lotto.utils.LottoValidateUtils.*;

import java.util.List;

public record Lotto(List<Integer> numbers) {

    public Lotto(final List<Integer> numbers) {
        validateLottoNumbers(numbers);
        this.numbers = numbers.stream()
            .sorted()
            .toList();
    }

    @Override
    public List<Integer> numbers() {
        return unmodifiableList(numbers);
    }
}
