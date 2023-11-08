package lotto.Validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @DisplayName("입력받은 로또번호들이 범위 안에 있는지 확인한다")
    @Test
    void numbersAllInRange() {
        Validator.validateNumbersInRange(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("입력받은 로또번호들 중 범위 안에 없는 번호가 있다면 예외처리한다")
    @Test
    void throwExceptionWhenNumbersContainNotInRangeNumber() {
        assertThatThrownBy(() -> {
            Validator.validateNumbersInRange(List.of(1, 2, 3, 4, 5, 46));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("각 로또번호가 범위 안에 있는지 확인한다")
    @Test
    void numberInRange() {
        Validator.validateNumberInRange(1);
    }

    @DisplayName("각 로또번호가 범위 안에 없다면 예외처리한다")
    @Test
    void throwExceptionWhenNumberIsNotInRange() {
        assertThatThrownBy(() -> {
            Validator.validateNumberInRange(46);
        }).isInstanceOf(IllegalArgumentException.class);

    }

}
