package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest{

    @DisplayName("로또 번호에 범위에서 벗어난 숫자가 있으면 git 예외가 발생한다.")
    @Test
    void 로또_번호_범위_예외() {
        assertThatThrownBy(() -> new Bonus(55))
                .isInstanceOf(IllegalArgumentException.class);
    }

}