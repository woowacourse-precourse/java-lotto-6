package lotto.domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BonusNumberTest {

    @DisplayName("보너스 번호를 생성한다.")
    @Test
    void createBonusNumberSuccess() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        BonusNumber bonusNumberInstance = new BonusNumber(winningNumbers, bonusNumber);

        // then
        Assertions.assertThat(bonusNumberInstance).isNotNull();
    }

    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicated() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 1;

        // then
        Assertions.assertThatThrownBy(() -> new BonusNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 볼은 로또 번호와 중복될 수 없습니다.");
    }
}
