package lotto.domain.winningNumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Nested
@DisplayName("보너스 번호 입력 테스트")
public class BonusNumberTest {

    @DisplayName("보너스 번호 - 입력이 숫자가 아닌 경우")
    @Test
    void testBonusNumberNotNumericInput() {
        String input = "1a";
        assertThatThrownBy(() -> new BonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 - 입력 숫자가 범위를 벗어난 경우")
    @Test
    void testBonusNumberOutOfRange() {
        String input = "-1";
        assertThatThrownBy(() -> new BonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 - 올바른 입력을 한 경우")
    @Test
    void testBonusNumber() {
        String input = "1";
        assertThatCode(() -> new BonusNumber(input))
                .doesNotThrowAnyException();
    }
}
