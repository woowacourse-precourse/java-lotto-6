package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {

    private static final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    @DisplayName("보너스 번호의 범위가 1~45를 넘어가면 예외가 발생한다.")
    @Test
    void createBonusByOverRange() {
        assertThatThrownBy(() -> new Bonus(46, lotto))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 범위가 1~45를 넘어가면 예외가 발생한다.")
    @Test
    void createBonusByUnderRange() {
        assertThatThrownBy(() -> new Bonus(0, lotto))
            .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("보너스 번호가 당첨 번호 숫자 중에 중복될 때 예외가 발생한다.")
    @Test
    void createBonusByDuplicate() {
        assertThatThrownBy(() -> new Bonus(3, lotto))
            .isInstanceOf(IllegalArgumentException.class);
    }

}