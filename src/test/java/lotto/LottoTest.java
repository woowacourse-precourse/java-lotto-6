package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("로또 번호에 1보다 작은 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByUnderMinimum() {
        assertThatThrownBy(() -> new Lotto(List.of(-1, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 45보다 큰 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByUnderMaximum() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 완전히 일치하는 경우 FIRST를 반환한다.")
    @Test
    void winFirstPrizeInLotto() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Ranking ranking = lotto.getRanking(winningLotto, bonusNumber);

        assertThat(ranking).isEqualTo(Ranking.FIRST);
    }

    @DisplayName("당첨 번호와 5개의 수가 일치하고 보너스 번호와 일치하는 경우 SECOND를 반환한다.")
    @Test
    void winSecondPrizeInLotto() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 5, 6, 7));
        Ranking ranking = lotto.getRanking(winningLotto, bonusNumber);

        assertThat(ranking).isEqualTo(Ranking.SECOND);
    }

    @DisplayName("로또와 일치하는 숫자가 없는 경우 NONE을 반환한다.")
    @Test
    void notWinInLotto() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        Lotto lotto = new Lotto(List.of(45, 44, 43, 42, 41, 40));
        Ranking ranking = lotto.getRanking(winningLotto, bonusNumber);

        assertThat(ranking).isEqualTo(null);
    }
}