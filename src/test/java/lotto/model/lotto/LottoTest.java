package lotto.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 객체 생성을 테스트한다.")
    @Test
    void createLottoByValidNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isNotNull();
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(
                () -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 범위인 1 ~ 45가 아니라면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 70)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 몇 개 일치하는지 테스트한다.")
    @Test
    void countMatchNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 10;
        Winning winning = Winning.of(lotto, bonus);

        int matchNumbers = lotto.countMatchNumbers(winning);

        assertThat(matchNumbers).isEqualTo(6);
    }

    @DisplayName("로또 보너스 번호가 일치하는지 테스트한다.")
    @Test
    void isMatchNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 3;

        boolean matchBonus = lotto.isMatchNumber(bonus);

        assertThat(matchBonus).isTrue();
    }
}