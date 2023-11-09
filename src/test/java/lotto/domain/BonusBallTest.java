package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class BonusBallTest {

    @Test
    void 보너스볼_검증_큼() {
        assertThatThrownBy(() -> new BonusBall(100, new Lotto(List.of(1,2,3,4,5,6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 45보다 큰 숫자는 입력 할 수 없습니다.");
    }

    @Test
    void 보너스볼_검증_작음() {
        assertThatThrownBy(() -> new BonusBall(0, new Lotto(List.of(1,2,3,4,5,6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1보다 작은 숫자는 입력 할 수 없습니다.");
    }

    @Test
    void 보너스볼_2등인지_확인() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,7));
        BonusBall bonusBall = new BonusBall(8, lotto);
        assertThat(bonusBall.contains(new LottoNumber(List.of(1,2,3,4,6,8)))).isEqualTo(2);
    }
}
