package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorForModelTest {
    ValidatorForModel validatorForModel = new ValidatorForModel();

    @DisplayName("입력받은 값에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void testDuplicateNumbers() {
        assertThatThrownBy(() -> validatorForModel.validate(List.of(1, 2, 3, 4, 5, 5))).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("입력받은 값이 6자리가 아닌 경우 예외가 발생한다.")
    @Test
    void testInputValueNotSixDigits() {
        assertThatThrownBy(() -> validatorForModel.validate(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 값이 1-45 범위가 아닌 경우 예외가 발생한다.")
    @Test
    void testInvalidRangeNumber() {
        assertThatThrownBy(() -> validatorForModel.validate(List.of(1, 2, 3, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}