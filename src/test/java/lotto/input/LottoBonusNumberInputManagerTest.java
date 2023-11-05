package lotto.input;

import java.util.Collections;
import lotto.exception.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoBonusNumberInputManagerTest {

    @DisplayName("로또 보너스 번호 크기 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "9999999999999"})
    void bonusSizeException(String input) {
        Assertions.assertThatThrownBy(() -> LottoBonusNumberInputManager.fromString(input, Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.WRONG_BONUS_NUMBER_SIZE);
    }
}