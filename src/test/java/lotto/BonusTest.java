package lotto;

import lotto.element.Bonus;
import lotto.element.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class BonusTest {
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void creatDuplicateNumber() {
        Lotto wins = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new Bonus(1, wins))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 보너스 번호가 포함되면 true 반환")
    @Test
    void executeIsBonusMatch() {
        Lotto wins = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Bonus bonus = new Bonus(7, wins);
        assertThat(bonus.isBonusMatch(lotto))
                .isEqualTo(true);
    }
}
