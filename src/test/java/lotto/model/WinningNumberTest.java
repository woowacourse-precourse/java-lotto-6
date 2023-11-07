package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;

public class WinningNumberTest {

    @DisplayName("보너스 번호 입력값을 검증한다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 46, 0})
    void 보너스_번호_입력값_검증(int bonusNumber) {
        Lotto numbers = Lotto.from(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> WinningNumber.from(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
