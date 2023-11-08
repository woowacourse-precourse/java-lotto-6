package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusTest {
    @DisplayName("보너스 번호를 1개 저장한다.")
    @Test
    void 보너스_번호를_정상적으로_저장하는_경우() {
        assertThatCode(() -> new Bonus(1))
                .doesNotThrowAnyException();
    }

    @DisplayName("1~45에서 벗어난 숫자라면 예외가 발생한다.")
    @Test
    void 보너스_번호_범위에서_벗어난_숫자() {
        assertThatThrownBy(() -> new Bonus(47))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
