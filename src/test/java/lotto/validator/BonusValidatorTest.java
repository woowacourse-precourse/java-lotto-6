package lotto.validator;

import static lotto.Option.ErrorMessage.ONE_TO_FORTY_FIVE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusValidatorTest {
    @DisplayName("범위를 벗어나는 값을 입력했을 때 오류를 던진다.")
    @Test
    void overRangeNumberThrowException() {
        assertThatThrownBy(() -> BonusValidator.range(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ONE_TO_FORTY_FIVE.getErrorMessage());
    }

    @DisplayName("범위를 벗어나는 값을 입력했을 때 오류를 던진다.")
    @Test
    void overRangeNumberThrowException_2() {
        assertThatThrownBy(() -> BonusValidator.range(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ONE_TO_FORTY_FIVE.getErrorMessage());
    }
}
