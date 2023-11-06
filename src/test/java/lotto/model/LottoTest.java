package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호의 일치 갯수만큼 정수를 반환한다.")
    void getMatchCount_expectNumber() {
        /**
         * given : 로또 번호와 당첨 번호가 주어진다.
         * when : getMatchCount 메서드를 호출한다.
         * then : 6개의 번호가 일치하기 때문에, 6을 반환한다.
         */

        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int matchCount = lotto.getMatchCount(winningNumber);

        assertThat(matchCount).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호에 보너스 번호가 포함되어 있지 않다면 false를 반환한다.")
    void hasBounus_isFalse() {
        /**
         * given : 로또 번호와 보너스 번호가 주어진다.
         * when : hasBonus 메서드를 호출한다.
         * then : 보너스 번호(7)가 포함되어 있지 않기 때문에, false를 반환한다.
         */
        BonusNumber bonusNumber = new BonusNumber("7");

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.hasBonus(bonusNumber)).isFalse();
    }

    @Test
    @DisplayName("로또 번호에 보너스 번호가 포함되어 있다면 true를 반환한다.")
    void hasBounus_isTrue() {
        /**
         * given : 로또 번호와 보너스 번호가 주어진다.
         * when : hasBonus 메서드를 호출한다.
         * then : 보너스 번호(7)가 포함되어 있기 때문에, true를 반환한다.
         */
        BonusNumber bonusNumber = new BonusNumber("7");

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        assertThat(lotto.hasBonus(bonusNumber)).isTrue();
    }
}