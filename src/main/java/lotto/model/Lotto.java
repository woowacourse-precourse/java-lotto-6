package lotto.model;

import java.util.List;
import lotto.exception.Constant;
import lotto.exception.ErrorMessage;

public class Lotto {

    private final List<Number> numbers; // private 변경 및 필드 추가 불가능

    private Lotto(List<Number> numbers) {
        validateNumbersLength(numbers);
        this.numbers = numbers;
    }

    private void validateNumbersLength(List<Number> numbers) {
        if (numbers.size() != Constant.LOTTO_NUMBERS_MAX_LENGTH.getIntValue()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_NUMBERS_LENGTH.get());
        }
    }

}
