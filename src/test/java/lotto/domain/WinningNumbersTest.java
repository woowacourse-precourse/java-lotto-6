package lotto.domain;

import static lotto.error.ErrorMessage.DUPLICATE_WINNING_NUMBER;
import static lotto.error.ErrorMessage.INVALID_WINNING_NUMBER_FORMAT;
import static lotto.error.ErrorMessage.INVALID_WINNING_NUMBER_LENGTH;
import static lotto.error.ErrorMessage.WINNING_NUMBER_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    @DisplayName("당첨 숫자 검증이 가능하다.")
    @Test
    void validateWinningNumbersTest() {
        assertAll(
                () -> assertThatThrownBy(() -> WinningNumbers.of("1,2,3,4,5,love"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(INVALID_WINNING_NUMBER_FORMAT),
                () -> assertThatThrownBy(() -> WinningNumbers.of("1,2,3,4,5,6,7"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(INVALID_WINNING_NUMBER_LENGTH),
                () -> assertThatThrownBy(() -> WinningNumbers.of("1,2,3,4,5,46"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(WINNING_NUMBER_OUT_OF_RANGE),
                () -> assertThatThrownBy(() -> WinningNumbers.of("1,2,3,4,6,6"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(DUPLICATE_WINNING_NUMBER),
                () -> assertThatCode(() -> WinningNumbers.of("1,2,3,4,5,6"))
                        .doesNotThrowAnyException()
        );
    }
}