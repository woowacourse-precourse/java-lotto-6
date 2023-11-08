package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static lotto.constant.ErrorMessage.DUPLICATED_BONUS;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    private Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("보너스 번호와 당첨번호가 중복될 시 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicated() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new BonusNumber(1, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_BONUS);
    }

    @DisplayName("보너스 번호가 주어진 로또 내에 포함되어 있는지 확인할 수 있다.")
    @Test
    void bonusNumberIsInLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        BonusNumber bonusNumber = new BonusNumber(7, winningNumbers);
        Assertions.assertThat(bonusNumber.isIn(lotto)).isTrue();
    }
}