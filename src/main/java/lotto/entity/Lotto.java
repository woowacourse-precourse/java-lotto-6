package lotto.entity;

import lotto.entity.mapper.FiledMapper;
import lotto.property.MethodProperty;

import java.util.Collections;
import java.util.List;

import static lotto.property.ErrorProperty.LOTTO_SIZE_IS_NOT_STANDARD;

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
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(
                (List<Integer>) FiledMapper.getFieldValue(this, MethodProperty.LOTTO_NUMBERS)
        );
    }
}
