package lotto.Util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PaserTest {
    @ParameterizedTest
    @ValueSource(strings = {"1,2,c,d,5,6", "1.2.3.4.5.6"})
    @DisplayName("올바르지 않은 입력값")
    void failed(String inputWinningNumber) {
        assertThatThrownBy(() -> Paser.createWinningLotto(inputWinningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}