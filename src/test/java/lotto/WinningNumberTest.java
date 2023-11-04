package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumberTest {

    @DisplayName("보너스 번호 입력값을 검증한다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 46, 0})
    void 보너스_번호_입력값_검증(int bonusNumber) {
        String[] winningNumber = {"1", "2", "3", "4", "5", "6"};

        assertThatThrownBy(() -> WinningNumber.from(winningNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
