package lotto.view;

import lotto.util.Validation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"-1", "a", "z00"})
    @DisplayName("구매 금액 입력 값이 숫자가 아닐 때 예외 발생")
    void testValidateIsNotNumber(String invalidInput) {
        Assertions.assertThatThrownBy(() -> Validation.validateIsNotNumber(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자가 아닌 다른 값이 입력되었습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            ",",
            "1,2,3,4,5,6,7,",
            "1,2,3,4,5,6,",
            "122,",
            "a,s,2,3,4,5"})
    @DisplayName("형식에 맞지 않는 당첨 번호를 입력받을 때 예외 발생")
    void testValidateWinningNumbersWithRegex(String invalidInput) {
        Assertions.assertThatThrownBy(() -> Validation.validateWinningNumbersWithRegex(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 구분 쉼표(,)를 기준으로 숫자 6개를 입력해야 합니다.");
    }
}