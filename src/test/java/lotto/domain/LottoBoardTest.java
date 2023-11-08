package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoBoard;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

class LottoBoardTest {
    private Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

    @DisplayName("당첨 번호, 로또 리스트, 보너스 번호를 입력받아 객체를 생성한다.")
    @Test
    void testValidBonusNumber() {
        //given
        int bonusNumber = 7;
        //when
        //then
        LottoBoard lottoBoard = new LottoBoard(winningLotto, bonusNumber, lottos);
    }

    @DisplayName("보너스 번호와 당첨 번호에 중복이 존재하는 경우, IllegalArgumentException을 발생시킨다.")
    @Test
    void testInvalidBonusNumber() {
        //given
        int bonusNumber = 5;
        //when
        //then
        assertThatThrownBy(() -> new LottoBoard(winningLotto, bonusNumber, lottos))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("lottos의 당첨 여부를 List로 저장해 반환한다.")
    @Test
    void testCalculateRanks(){
        //given
        Lotto firstLotto = Mockito.mock(Lotto.class);
        Lotto secondLotto = Mockito.mock(Lotto.class);
        Lotto thirdLotto = Mockito.mock(Lotto.class);
        when(firstLotto.calculateRank(Mockito.anyList(), Mockito.anyInt()))
                .thenReturn(Rank.FIRST);
        when(secondLotto.calculateRank(Mockito.anyList(), Mockito.anyInt()))
                .thenReturn(Rank.SECOND);
        when(thirdLotto.calculateRank(Mockito.anyList(), Mockito.anyInt()))
                .thenReturn(Rank.THIRD);
        List<Lotto> lottos = List.of(firstLotto, secondLotto, thirdLotto);

        //when
        LottoBoard lottoBoard = new LottoBoard(winningLotto, 7, lottos);
        List<Rank> ranks = lottoBoard.calculateRanks();

        //then
        assertThat(ranks)
                .containsOnlyOnce(Rank.FIRST)
                .containsOnlyOnce(Rank.SECOND)
                .containsOnlyOnce(Rank.THIRD)
                .doesNotContain(Rank.FORTH)
                .doesNotContain(Rank.FIFTH);
    }
}