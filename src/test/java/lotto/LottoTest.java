package lotto;

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

    @DisplayName("로또 번호가 1~45 범위가 아니면 예외가 발생한다.")
    @Test
    void createLottoByMaxNumberRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45 범위가 아니면 예외가 발생한다.")
    @Test
    void createLottoByMinNumberRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 로또 번호의 일치하는 개수를 반환한다.")
    @Test
    void countMatches() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        int countMatches = lotto.countMatches(winningLotto);

        //then
        assertThat(countMatches).isEqualTo(6);
    }

    @DisplayName("로또에 보너스 번호가 있는지 확인한다.")
    @Test
    void additionalNumberFalse() {
        //given
        int bonusNumber = 7;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        boolean additionalNumber = lotto.additionalNumber(bonusNumber);

        //then
        assertThat(additionalNumber).isFalse();
    }

    @DisplayName("로또에 보너스 번호가 있는지 확인한다.")
    @Test
    void additionalNumberTrue() {
        //given
        int bonusNumber = 1;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        boolean additionalNumber = lotto.additionalNumber(bonusNumber);

        //then
        assertThat(additionalNumber).isTrue();
    }
}