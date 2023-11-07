package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusTest {
    @DisplayName("보너스 번호의 범위가 1 미만 혹은 45 초과일 경우 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> new Bonus(0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Bonus(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
