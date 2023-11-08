package lotto.domain;

import static lotto.error.ErrorMessage.DUPLICATE_WINNING_NUMBER;
import static lotto.error.ErrorMessage.INVALID_WINNING_NUMBER_FORMAT;
import static lotto.error.ErrorMessage.INVALID_WINNING_NUMBER_LENGTH;
import static lotto.error.ErrorMessage.WINNING_NUMBER_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    @DisplayName("당첨 숫자 생성 시 검증이 가능하다.")
    @Test
    void ofTest() {
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

    @DisplayName("당첨 숫자에 특정 숫자가 포함되었는지 확인 가능하다.")
    @Test
    void containsTest() {
        WinningNumbers winningNumbers = WinningNumbers.of("1,2,3,4,5,6");
        assertAll(
                () -> assertThat(winningNumbers.contains(1)).isEqualTo(true),
                () -> assertThat(winningNumbers.contains(7)).isEqualTo(false)
        );
    }
}