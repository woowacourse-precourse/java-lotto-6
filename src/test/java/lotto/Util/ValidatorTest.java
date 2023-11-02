package lotto.Util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    @Test
    @DisplayName("null 혹은 빈값 유효성 검사 테스트")
    public void isNullOrEmptyTest() {
        String nullValue = null;
        String empty = "";

        // null 입력 예외 발생 확인
        assertThatThrownBy(() -> Validator.validateNullOrEmpty(nullValue))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(Validator.NULL_OR_EMPTY_MESSAGE);

        // 빈 문자열 예외 발생 확인
        assertThatThrownBy(() -> Validator.validateNullOrEmpty(empty))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(Validator.NULL_OR_EMPTY_MESSAGE);
    }

    @Test
    @DisplayName("1000 단위 숫자 유효성 검사 테스트")
    public void validateBudgetInThousandsTest() {
        String invalidInput = "19400";
        String validInput = "19000";

        // 유효하지 않은 입력에 대한 테스트
        assertThatThrownBy(() -> Validator.validateBudgetInThousands(invalidInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(Validator.THOUSANDS_MULTIPLE_MESSAGE);

        // 유효한 입력에 대한 테스트
        assertDoesNotThrow(() -> Validator.validateBudgetInThousands(validInput));
    }
}
