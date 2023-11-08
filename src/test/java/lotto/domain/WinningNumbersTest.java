package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersTest {

    @DisplayName("보너스 볼 - 범위를 벗어났거나, 당첨 번호 중복일 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-3, 46, 13})
    void makeBonusNumber(int input) {
        Lotto winningNumbers = new Lotto(List.of(4, 12, 13, 41, 1, 17));
        assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumbers(winningNumbers, input);
        });
    }
}