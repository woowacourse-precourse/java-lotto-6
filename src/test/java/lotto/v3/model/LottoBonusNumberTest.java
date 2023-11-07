package lotto.v3.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoBonusNumberTest {
    @Test
    @DisplayName("보너스 번호가 1부터 45 사이 값인지 검증")
    void testBonusNumberWithinRange() {
        // Given
        int validBonusNumber = 45;
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);

        // When & Then
        assertThatCode(() -> new LottoBonusNumber(validBonusNumber, winningNumbers))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("보너스 번호가 1보다 작을 때 예외를 던지는지 검증")
    void testBonusNumberBelowRange() {
        // Given
        int invalidBonusNumber = 0;
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);

        // When & Then
        assertThatThrownBy(() -> new LottoBonusNumber(invalidBonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이의 값이어야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 45보다 클 때 예외를 던지는지 검증")
    void testBonusNumberAboveRange() {
        // Given
        int invalidBonusNumber = 46;
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);

        // When & Then
        assertThatThrownBy(() -> new LottoBonusNumber(invalidBonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이의 값이어야 합니다.");
    }

}