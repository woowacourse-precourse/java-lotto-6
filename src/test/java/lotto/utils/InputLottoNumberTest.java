package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputLottoNumberTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    @DisplayName("빈 칸이 입력으로 들어왔을 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {""})
    void 입력값_빈칸인_경우(String input) {
        assertThatThrownBy(() -> Validator.checkNullValue(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("보너스 번호가 형식에 올바르지 않게 들어왔을 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,false,4,5"})
    void 보너스번호_입력형태_잘못된_경우(String input) {
        assertThatThrownBy(() -> Validator.checkBonusNumberForm(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
