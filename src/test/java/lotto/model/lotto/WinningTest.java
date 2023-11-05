package lotto.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningTest {
    private final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("로또 당첨 번호 객체 생성을 테스트한다.")
    @Test
    void createLottoByValidNumber() {
        int bonus = 10;
        Winning winning = Winning.of(lotto, bonus);
        assertThat(winning).isNotNull();
        assertThat(winning.getLotto()).isEqualTo(lotto);
        assertThat(winning.getBonus()).isEqualTo(bonus);
    }

    @DisplayName("로또 당첨 번호와 보너스 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        int bonus = 3;
        assertThatThrownBy(() -> Winning.of(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 보너스 번호가 범위인 1 ~ 45가 아니라면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> Winning.of(lotto, 100))
                .isInstanceOf(IllegalArgumentException.class);
    }
}