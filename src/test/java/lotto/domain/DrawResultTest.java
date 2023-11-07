package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DrawResultTest {
    @DisplayName("보너스 번호가 당첨 번호에 포함되면 예외가 발생한다.")
    @Test
    void createDrawResultByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> new DrawResult(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 범위 밖의 숫자이면 예외가 발생한다.")
    @Test
    void createDrawResultByBonusNumberOutOfRange() {
        assertThatThrownBy(() -> new DrawResult(List.of(1, 2, 3, 4, 5, 6), -1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
