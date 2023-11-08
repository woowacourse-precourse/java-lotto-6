package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @DisplayName("정수와 로또 번호를 통해 생성할 수 있다.")
    @Test
    void createByInteger() {
        // given
        int number = 10;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        BonusNumber bonusNumber = BonusNumber.of(number, lotto);

        // then
        assertThat(bonusNumber.getNumber()).isEqualTo(number);
    }

    @DisplayName("보너스 번호가 1~45 사이가 아니라면 예외가 발생한다.")
    @Test
    void createByInvalidRangeNumber() {
        // given
        int number = 50;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when, then
        assertThatThrownBy(() -> BonusNumber.of(number, lotto))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("보너스 번호는 1 이상 45 이하여야 합니다.");
    }

    @DisplayName("보너스 번호가 로또 번호와 중복이 있으면 예외가 발생한다.")
    @Test
    void creatByDuplicatedBonusNumber() {
        // given
        int number = 1;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when, then
        assertThatThrownBy(() -> BonusNumber.of(number, lotto))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("보너스 번호는 로또 번호와 중복될 수 없습니다.");
    }

    @DisplayName("입력한 로또 번호에 보너스 번호가 포함되어있는지 판단한다.")
    @Test
    void checkBonusNumberIsContainedInInputLotto() {
        // given
        int number = 10;
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.of(number, winningLotto);

        Lotto targetLotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        Lotto targetLotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        boolean result1 = bonusNumber.containsInLotto(targetLotto1);
        boolean result2 = bonusNumber.containsInLotto(targetLotto2);

        // then
        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
    }
}