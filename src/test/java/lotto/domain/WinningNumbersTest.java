package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersTest {
    WinningNumbers numbers = new WinningNumbers();

    @DisplayName("보너스 볼- 범위를 벗어났거나, 당첨 번호 중복일 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-3, 46, 13})
    void makeBonusNumber(int input) {
        numbers.makeWinningNumber(List.of(13, 22, 4, 5, 31, 17));
        assertThatThrownBy(() ->
                numbers.makeBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}