package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    @Test
    @DisplayName("당첨 번호에 중복된 보너스 번호로 생성할때 예외 처리")
    void createWinningNumbersByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 숫자를 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("보너스 번호가 1미만이거나 45초과이거나 예외 처리")
    void createWinningNumbersByBonusNumberOutOfRange() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

}