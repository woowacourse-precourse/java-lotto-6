package lotto.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoValidationTest {

    @DisplayName("입력값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createValueByNotNumber() {
        String input = "three";

        assertThatThrownBy(() -> LottoValidation.validateIsNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값은 숫자여야 합니다.");
    }

    @DisplayName("구입 금액이 1000원 미만이면 예외가 발생한다.")
    @Test
    void createValueByUnderThousand() {
        int input = 900;

        assertThatThrownBy(() -> LottoValidation.validateOverStandardUnit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 최소 1000원입니다.");
    }

    @DisplayName("구입 금액이 1000원으로 나누어지지 않으면 예외가 발생한다.")
    @Test
    void createValueByInDivisible() {
        int input = 4400;

        assertThatThrownBy(() -> LottoValidation.validateIsStandardUnit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
    }

    @DisplayName("로또 번호가 1~45사이가 아니면 예외가 발생한다.")
    @Test
    void createLottoNumberByOutOfRange() {
        int number = 46;

        assertThatThrownBy(() -> LottoValidation.validateInRange(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1~45사이의 숫자여야 합니다.");
    }
}
