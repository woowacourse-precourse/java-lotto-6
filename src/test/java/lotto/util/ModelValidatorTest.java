package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ModelValidatorTest {

    @DisplayName("번호가 범위에 맞지 않으면 예외가 발생한다.")
    @Test
    void validateOutOfRange() {
        //given
        int number = 0;
        int startNumber = 1;
        int endNumber = 45;
        //when
        //then
        assertThatThrownBy(() ->
                ModelValidator.validateOutOfRange(number, startNumber, endNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}