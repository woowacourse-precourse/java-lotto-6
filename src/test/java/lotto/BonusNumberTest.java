package lotto;

import lotto.Validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    @DisplayName("정수가 아닌 문자를 입력할 경우 예외가 발생한다.")
    @Test
    void createInputBonusNumberNotInteger() {
        assertThatThrownBy(() -> Parser.parseBonusNumber("f"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 정수만 입력할 수 있습니다.\n");
    }
}
