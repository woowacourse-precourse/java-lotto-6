package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinNumberTest {
    @DisplayName("당첨 번호가 보너스 번호와 중복되면 IllegalArgumentException이 발생하고 다시 입력값을 받는다.")
    @Test
    void createWinNumberByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> WinNumber.from(List.of(1, 2, 3, 4, 5, 6), 5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}