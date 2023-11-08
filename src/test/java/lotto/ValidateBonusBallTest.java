package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.BonusBall;
import lotto.domain.Lotto;
import lotto.domain.validator.ValidateBonusBall;
import org.junit.jupiter.api.Test;

public class ValidateBonusBallTest {

    @Test
    void 범위_내의_숫자_큼() {
        assertThatThrownBy(() -> new ValidateBonusBall().isInRange(46))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR] 45보다 큰 숫자는 입력 할 수 없습니다.");
    }

    @Test
    void 범위_내의_숫자_작음() {
        assertThatThrownBy(() -> new ValidateBonusBall().isInRange(0))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR] 1보다 작은 숫자는 입력 할 수 없습니다.");
    }

    @Test
    void 보너스볼_중복() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThatThrownBy(() -> new BonusBall(1, lotto))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR] 보너스볼의 숫자와 같은 숫자가 존재합니다.");
    }

}
