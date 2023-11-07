package lotto.global.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {
    private Validation validation;

    @BeforeEach
    void setUp() {
        validation = new Validation();
    }

    @DisplayName("빈 값을 입력하면 예외가 발생한다.")
    @Test
    void inputEmptyValue() {
        assertThatThrownBy(() -> validation.oneWordAndOver(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 한 글자 이상 입력해 주세요.");
    }

    @DisplayName("입력값이 1000의 배수가 아니면 예외가 발생한다.")
    @Test
    void inputNotMultipleOf1000() {
        assertThatThrownBy(() -> validation.multipleOfThousand(2500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매금액은 1,000원 단위로 입력해 주세요.");
    }

    @DisplayName("입력값이 음수면 예외가 발생한다.")
    @Test
    void inputNegative() {
        assertThatThrownBy(() -> validation.multipleOfThousand(-2500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매금액은 1,000원 단위로 입력해 주세요.");
    }


}