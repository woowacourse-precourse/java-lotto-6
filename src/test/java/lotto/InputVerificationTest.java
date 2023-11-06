package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputVerificationTest {
    private static InputVerification inputVerification = new InputVerification();

    @DisplayName("1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void isMultipleOfThousandTest() {
        assertThatThrownBy( () -> inputVerification.isMultipleOfThousand(1234))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1000의 배수가 아닙니다.");

        inputVerification.isMultipleOfThousand(12000);
    }

    @DisplayName("숫자가 1~45 사이에 없다면, 예외가 발생한다.")
    @Test
    void isNumberInRangeTest() {
        assertThatThrownBy(() -> inputVerification.isNumberInRange(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1~45 사이의 수가 아닙니다.");

        inputVerification.isNumberInRange(1);
        inputVerification.isNumberInRange(44);
    }

    @DisplayName("리스트의 숫자가 1~45 사이에 없다면, 예외가 발생한다.")
    @Test
    void isNumbersInRangeTest() {

        assertThatThrownBy(() -> inputVerification.isNumbersInRange(List.of(1, 2, 46, 45, 33, 22)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1~45 사이의 수가 아닙니다.");

        inputVerification.isNumbersInRange(List.of(1, 2, 3, 4, 5, 6));
    }
}
