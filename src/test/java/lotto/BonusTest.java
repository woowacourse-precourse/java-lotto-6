package lotto;

import lotto.domain.lotto.Bonus;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusTest {

    @Test
    @DisplayName("보너스 번호 입력 받기")
    void of() {
        Bonus bonus = Bonus.of(1);

        assertThat(bonus).isEqualTo(Bonus.of(1));
    }

    @Test
    @DisplayName("보너스 번호가 로또 번호와 같으면 예외가 발생한다.")
    void createBonusByDuplicatedNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> {
            Bonus bonus = Bonus.ofAndCheckDuplicatedNumber(lotto, 6);
        })
        .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 로또 번호와 중복되지 않으면 보너스 번호를 반환한다.")
    void createBonusByNotDuplicatedNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = Bonus.ofAndCheckDuplicatedNumber(lotto, 7);
        assertThat(bonus).isEqualTo(Bonus.of(7));
    }

    @Test
    @DisplayName("보너스 번호가 1 ~ 45 사이의 숫자가 아니면 예외가 발생한다.")
    void createBonusByNotInRange() {
        assertThatThrownBy(() -> {
            Bonus bonus = Bonus.of(46);
        })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}