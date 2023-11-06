package lotto.domain;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
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

    // 아래에 추가 테스트 작성 가능

    @DisplayName("로또 번호 중 범위를 넘어간 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 60)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 3개 이하의 번호가 일치하는 경우 RANK.NON_RANKING 반환한다.")
    @Test
    void matchWithNumbers_NON_RANKING() {
        // given
        Lotto lottoZero = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        Lotto lottoOne = new Lotto(Arrays.asList(1, 7, 8, 9, 10, 11));
        Lotto lottoTwo = new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10));
        WinLotto winLotto = new WinLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 10);

        // when
        Ranking rankingZero = lottoZero.matchWithWinLotto(winLotto);
        Ranking rankingOne = lottoOne.matchWithWinLotto(winLotto);
        Ranking rankingTwo = lottoTwo.matchWithWinLotto(winLotto);

        // then
        assertThat(rankingZero).isEqualTo(Ranking.NON_RANKING);
        assertThat(rankingOne).isEqualTo(Ranking.NON_RANKING);
        assertThat(rankingTwo).isEqualTo(Ranking.NON_RANKING);
    }

    @DisplayName("로또의 3개의 번호가 일치하는 경우 RANK.FIFTH를 반환한다.")
    @Test
    void matchWithNumbers_FIFTH() {
        // given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinLotto winLotto = new WinLotto(Arrays.asList(1, 2, 3, 7, 8, 9), 10);

        // when
        Ranking ranking = lotto.matchWithWinLotto(winLotto);

        // then
        assertThat(ranking).isEqualTo(Ranking.FIFTH);
    }

    @DisplayName("로또의 4개의 번호가 일치하는 경우 RANK.FOURTH를 반환한다.")
    @Test
    void matchWithNumbers_FOURTH() {
        // given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinLotto winLotto = new WinLotto(Arrays.asList(1, 2, 3, 4, 8, 9), 10);

        // when
        Ranking ranking = lotto.matchWithWinLotto(winLotto);

        // then
        assertThat(ranking).isEqualTo(Ranking.FOURTH);
    }
    @DisplayName("로또의 5개의 번호가 일치하는 경우 RANK.THIRD를 반환한다.")
    @Test
    void matchWithNumbers_THIRD() {
        // given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinLotto winLotto = new WinLotto(Arrays.asList(1, 2, 3, 4, 5, 9), 10);

        // when
        Ranking ranking = lotto.matchWithWinLotto(winLotto);

        // then
        assertThat(ranking).isEqualTo(Ranking.THIRD);
    }
    @DisplayName("로또의 5개의 번호와 보너스 번호가 일치하는 경우 RANK.SECOND를 반환한다.")
    @Test
    void matchWithNumbers_SECOND() {
        // given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinLotto winLotto = new WinLotto(Arrays.asList(1, 2, 3, 4, 5, 9), 6);

        // when
        Ranking ranking = lotto.matchWithWinLotto(winLotto);

        // then
        assertThat(ranking).isEqualTo(Ranking.SECOND);
    }
    @DisplayName("로또 6개의 번호가 일치하는 경우 RANK.FIRST 반환한다.")
    @Test
    void matchWithNumbers_FIRST() {
        // given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinLotto winLotto = new WinLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        // when
        Ranking ranking = lotto.matchWithWinLotto(winLotto);

        // then
        assertThat(ranking).isEqualTo(Ranking.FIRST);
    }
}