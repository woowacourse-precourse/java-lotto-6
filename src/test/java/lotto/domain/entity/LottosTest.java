package lotto.domain.entity;

import lotto.service.manager.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottosTest {

    @DisplayName("추첨 등수 계산 성공")
    @Test
    public void calculateRankings() throws  Exception {
        //given
        Lotto target = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 10;

        Lotto notingLotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        Lotto firstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = new Lotto(List.of(2, 3, 4, 5, 6, bonusNumber));
        Lotto thirdLotto = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        Lotto fourthLotto = new Lotto(List.of(3, 4, 5, 6, 7, 8));
        Lotto fifthLotto = new Lotto(List.of(4, 5, 6, 7, 8, 9));

        Lottos lottos = new Lottos(
                List.of(
                        notingLotto,
                        firstLotto,
                        secondLotto,
                        thirdLotto,
                        fourthLotto,
                        fifthLotto
                )
        );

        long expectedSize = 5;
        Rank[] expected = {
                Rank.FIRST,
                Rank.SECOND,
                Rank.THIRD,
                Rank.FOURTH,
                Rank.FIFTH
        };

        //when
        List<Rank> result = lottos.calculateRankings(target, bonusNumber);
        //then
        Assertions.assertThat(result.size()).isEqualTo(expectedSize);
        Assertions.assertThat(result).containsExactly(expected);
    }

}