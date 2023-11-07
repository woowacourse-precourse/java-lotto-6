package lotto.domain;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 범위가 1~45를 벗어난다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("45");
    }

    @DisplayName("보너스 번호의 범위가 1~45를 벗어난다.")
    @Test
    void inputBonusByOverRange() {
        Lotto winningNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 46;

        assertThatThrownBy(() -> winningNum.validateBonus(winningNum, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("45");
    }

    @DisplayName("보너스 번호와 당첨 번호 중 중복된 값이 존재한다.")
    @Test
    void inputBonusByDuplicatedNum() {
        Lotto winningNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 6;

        assertThatThrownBy(() -> winningNum.validateBonus(winningNum, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @DisplayName("당첨 번호와 로또 번호를 비교하는 도메인 로직 테스트.")
    @Test
    void compareWinningWithLotto() {
        Lotto winningNum = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));

        Assertions.assertThat(lotto.compareLottoWithWinning(winningNum)).isEqualTo(4);
    }
}