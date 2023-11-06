package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.constants.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoManagerTest {

    @DisplayName("로또 리스트를 오름차순으로 정렬")
    @Test
    void sortLottos() {
        // given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(6, 5, 4, 3, 2, 1)));
        lottos.add(new Lotto(List.of(5, 1, 2, 3, 4, 6)));

        // when
        List<Lotto> sortedlottos = LottoManager.sortLottos(lottos);

        // then
        for (Lotto sortedlotto : sortedlottos) {
            assertThat(sortedlotto.getNumbers())
                    .isEqualTo(List.of(1, 2, 3, 4, 5, 6))
                    .isNotEqualTo(List.of(6, 5, 4, 3, 2, 1));
        }
    }

    @DisplayName("당첨로또와 일치하는 횟수 계산")
    @Test
    void countMatching() {
        // given
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));

        // when
        Integer countMatching = LottoManager.countMatching(userLotto, winningLotto);

        // then
        assertThat(countMatching).isEqualTo(6);
    }


    @DisplayName("로또 당첨 결과 반환")
    @Test
    void checkWinning() {
        // given
        List<Lotto> userLottos = new ArrayList<>();
        userLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        userLottos.add(new Lotto(List.of(1, 2, 3, 7, 8, 9)));

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 1등: 1, 5등: 1
        Integer bonusNumber = 10;

        // when
        LottoResult lottoResult = LottoManager.checkWinning(userLottos, winningLotto, bonusNumber);

        // then
        assertThat(lottoResult.state.get(Prize.FIRST)).isEqualTo(1);
        assertThat(lottoResult.state.get(Prize.FIFTH)).isEqualTo(1);

    }



}