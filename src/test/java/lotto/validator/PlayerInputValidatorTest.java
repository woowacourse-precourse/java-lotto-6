package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerInputValidatorTest {

    @DisplayName("로또 입력값 오류 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"aaa", "-1000", "1500"})
    void lottoErrorInput(String input) {
        assertThrows(IllegalArgumentException.class, () -> PlayerInputValidator.validate(input));
    }
}