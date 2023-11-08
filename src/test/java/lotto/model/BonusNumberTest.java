package lotto.model;

import static lotto.common.Constant.MAX_RANGE;
import static lotto.common.Constant.MIN_RANGE;
import static lotto.common.ExceptionMessage.ERROR_INVALID_INTEGER;
import static lotto.common.ExceptionMessage.ERROR_NUMBER_NOT_IN_RANGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {
    @DisplayName("올바른 문자열 입력 값으로 BonusNumber를 생성한다.")
    @Test
    void createBonusNumberFromValidInput() {
        String validInput = "12";
        BonusNumber bonusNumber = BonusNumber.from(validInput);

        assertThat(bonusNumber.getBonusNumber()).isEqualTo(12);
    }

    @DisplayName("입력 값이 숫자가 아니면 IllegalArgumentException을 던진다.")
    @Test
    void throwExceptionWhenInputIsNotANumber() {
        String invalidInput = "abc";

        assertThatThrownBy(() -> BonusNumber.from(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_INVALID_INTEGER);
    }

    @DisplayName("입력 값이 범위 밖의 숫자이면 IllegalArgumentException을 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "46"})
    void throwExceptionWhenInputIsOutOfRange(String invalidInput) {
        assertThatThrownBy(() -> BonusNumber.from(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_NUMBER_NOT_IN_RANGE, MIN_RANGE, MAX_RANGE);
    }
}
