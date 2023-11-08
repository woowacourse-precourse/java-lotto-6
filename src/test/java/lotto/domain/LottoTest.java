package lotto.domain;

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

    @DisplayName("로또 번호가 6개보다 적으면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1보다 작거나 45보다 크면 예외가 발생한다.")
    @Test
    void createLottoByNumberRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 0, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 오름차순으로 정렬되어 생성된다.")
    @Test
    void createLottoByAscendingOrder() {
        Lotto lotto = new Lotto(List.of(3, 2, 1, 6, 5, 4));
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("당첨 로또와 입력한 로또 번호 및 보너스 번호 비교를 하여 Rank를 반환한다.")
    @Test
    void getRank_로또_번호_비교() {
        compareLottos_로또_번호_6개_일치();
        compareLottos_로또_번호_5개_일치_보너스_일치();
        compareLottos_로또_번호_5개_일치();
        compareLottos_로또_번호_4개_일치();
        compareLottos_로또_번호_3개_일치();
    }

    void compareLottos_로또_번호_6개_일치() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(winningLotto.getRank(lotto, bonusNumber)).isEqualTo(Rank.FIRST);
    }

    void compareLottos_로또_번호_5개_일치_보너스_일치() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertThat(winningLotto.getRank(lotto, bonusNumber)).isEqualTo(Rank.SECOND);
    }

    void compareLottos_로또_번호_5개_일치() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        assertThat(winningLotto.getRank(lotto, bonusNumber)).isEqualTo(Rank.THIRD);
    }

    void compareLottos_로또_번호_4개_일치() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        assertThat(winningLotto.getRank(lotto, bonusNumber)).isEqualTo(Rank.FOURTH);
    }

    void compareLottos_로또_번호_3개_일치() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        assertThat(winningLotto.getRank(lotto, bonusNumber)).isEqualTo(Rank.FIFTH);
    }

}