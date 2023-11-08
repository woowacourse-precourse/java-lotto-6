package lotto.entity;

import lotto.entity.mapper.FiledMapper;
import lotto.property.MethodProperty;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static lotto.property.ErrorProperty.LOTTO_SIZE_IS_NOT_STANDARD;
import static lotto.property.ErrorProperty.WINNING_NUMBER_IS_DUPLICATE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_SIZE_IS_NOT_STANDARD.toString());
        }

        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(WINNING_NUMBER_IS_DUPLICATE.toString());
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(
                (List<Integer>) FiledMapper.getFieldValue(this, MethodProperty.LOTTO_NUMBERS)
        );
    }
}
