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
        List<Lotto> sortedLottos = LottoManager.sortLottos(lottos);

        // then
        for (Lotto sortedlotto : sortedLottos) {
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


    @DisplayName("로또 1등 당첨")
    @Test
    void checkWinning() {
        // given
        List<Lotto> userLottos = new ArrayList<>();
        userLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6))); // 6개 일치, 1등

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 10;

        // when
        LottoResult lottoResult = LottoManager.checkWinning(userLottos, winningLotto, bonusNumber);

        // then
        assertThat(lottoResult.state.get(Prize.FIRST)).isEqualTo(1);

        for (Prize prize : lottoResult.state.keySet()) {
            if (prize == Prize.FIRST){
                continue;
            }

            assertThat(lottoResult.state.get(prize)).isEqualTo(0);
        }
    }

    @DisplayName("로또 2등 당첨")
    @Test
    void checkSecondWinning() {
        // given
        List<Lotto> userLottos = new ArrayList<>();
        userLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));   // 5개 일치 + 보너스번호 일치, 2등

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Integer bonusNumber = 6;

        // when
        LottoResult lottoResult = LottoManager.checkWinning(userLottos, winningLotto, bonusNumber);

        // then
        assertThat(lottoResult.state.get(Prize.SECOND)).isEqualTo(1);

        for (Prize prize : lottoResult.state.keySet()) {
            if (prize == Prize.SECOND){
                continue;
            }

            assertThat(lottoResult.state.get(prize)).isEqualTo(0);
        }
    }

    @DisplayName("로또 3등 당첨")
    @Test
    void checkThirdWinning() {
        // given
        List<Lotto> userLottos = new ArrayList<>();
        userLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));   // 5개 일치, 3등

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 12));
        Integer bonusNumber = 20;

        // when
        LottoResult lottoResult = LottoManager.checkWinning(userLottos, winningLotto, bonusNumber);

        // then
        assertThat(lottoResult.state.get(Prize.THIRD)).isEqualTo(1);

        for (Prize prize : lottoResult.state.keySet()) {
            if (prize == Prize.THIRD){
                continue;
            }

            assertThat(lottoResult.state.get(prize)).isEqualTo(0);
        }
    }

    @DisplayName("로또 4등 당첨")
    @Test
    void checkFourthWinning() {
        // given
        List<Lotto> userLottos = new ArrayList<>();
        userLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 20)));   // 4개 일치 + 보너스 번호 일치, 4등
        userLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));   // 4개 일치, 4등

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 11, 12));
        Integer bonusNumber = 20;

        // when
        LottoResult lottoResult = LottoManager.checkWinning(userLottos, winningLotto, bonusNumber);

        // then
        assertThat(lottoResult.state.get(Prize.FOURTH)).isEqualTo(2);

        for (Prize prize : lottoResult.state.keySet()) {
            if (prize == Prize.FOURTH){
                continue;
            }

            assertThat(lottoResult.state.get(prize)).isEqualTo(0);
        }
    }

    @DisplayName("로또 5등 당첨")
    @Test
    void checkFifthWinning() {
        // given
        List<Lotto> userLottos = new ArrayList<>();
        userLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 20)));   // 3개 일치 + 보너스 번호 일치, 5등
        userLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));   // 3개 일치, 5등

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        Integer bonusNumber = 20;

        // when
        LottoResult lottoResult = LottoManager.checkWinning(userLottos, winningLotto, bonusNumber);

        // then
        assertThat(lottoResult.state.get(Prize.FIFTH)).isEqualTo(2);

        for (Prize prize : lottoResult.state.keySet()) {
            if (prize == Prize.FIFTH){
                continue;
            }

            assertThat(lottoResult.state.get(prize)).isEqualTo(0);
        }
    }


}