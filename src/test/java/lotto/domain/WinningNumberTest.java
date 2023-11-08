package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import lotto.utils.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    WinningNumber winningNumber;

    @BeforeEach
    void init() {
        winningNumber = new WinningNumber();
    }

    @Test
    @DisplayName("보너스 번호 범위 예외 발생")
    void bonusNumberRange() {
        // Given
        int bonusNumber = 50;

        // When
        // Then
        Assertions.assertThatThrownBy(() -> winningNumber.creatBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR_NUMBER_RANGE);
    }
}