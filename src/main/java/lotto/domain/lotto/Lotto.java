package lotto.domain.lotto;

import static lotto.domain.lotto.LottoErrorMessage.DUPLICATION_ERROR;
import static lotto.domain.lotto.LottoErrorMessage.SIZE_ERROR;
import static lotto.domain.lotto.LottoNumberConfig.NUMBER_COUNT;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if(validateSize(numbers)) {
            throw new IllegalArgumentException(SIZE_ERROR.getMessage());
        }
        if(validateDuplication(numbers)) {
            throw new IllegalArgumentException(DUPLICATION_ERROR.getMessage());
        }
    }

    private boolean validateSize(List<Integer> numbers) {
        return  (numbers.size() != NUMBER_COUNT.getValue());
    }

    private boolean validateDuplication(List<Integer> numbers) {
        return (numbers.stream()
                .distinct()
                .count() != NUMBER_COUNT.getValue());
    }


}
