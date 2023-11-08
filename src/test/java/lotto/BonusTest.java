package lotto;

import lotto.model.Bonus;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusTest {
    @DisplayName("보너스 번호가 제한된 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createBonusLottoByOverRange() {
        assertThatThrownBy(() -> new Bonus(50))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("발행 로또에 보너스 번호가 포함되어 있으면 0.5점을 반환한다.")
    @Test
    void containBonusNumberInLotto() {

        Bonus bonus = new Bonus(35);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 35));

        float count = bonus.countSameNumber(lotto);

        assertThat(count).isEqualTo(0.5f);
    }

    @DisplayName("발행 로또에 보너스 번호가 포함되어 있지 않으면 0점을 반환한다.")
    @Test
    void notContainBonusNumberInLotto() {

        Bonus bonus = new Bonus(35);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        float count = bonus.countSameNumber(lotto);

        assertThat(count).isEqualTo(0);
    }
}
