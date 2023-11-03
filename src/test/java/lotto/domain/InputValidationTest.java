package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputValidationTest {
    @Test
    void 입력받은_문자열이_숫자가_아니면_예외처리() {
        assertThatThrownBy(() -> InputValidation.checkNumber("1000a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자가 아닙니다.");
    }
}