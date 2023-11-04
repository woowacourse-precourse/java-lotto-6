package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosRepositoryTest {

    LottosRepository lottosRepository = new LottosRepository();

    @DisplayName("사용자 로또 묶음을 저장할 수 있다.")
    @Test
    void saveUserLottos() {
        // given
        Lotto lotto1 = Lotto.createFrom(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto2 = Lotto.createFrom(List.of(1, 2, 3, 4, 5, 6));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2));

        // when
        lottosRepository.saveUserLottos(lottos);
        Lottos findLottos = lottosRepository.findUserLottos().get();

        // then
        assertThat(findLottos).isEqualTo(lottos);
    }

    @DisplayName("당첨 로또 번호를 저장할 수 있다.")
    @Test
    void saveWinningNumber() {
        // given
        Lotto winningLotto = Lotto.createFrom(List.of(1, 2, 3, 4, 5, 6));

        // when
        lottosRepository.saveWiningLotto(winningLotto);
        Lotto findWinningLotto = lottosRepository.findWinningLotto().get();

        // then
        assertThat(findWinningLotto).isEqualTo(winningLotto);
    }

    @DisplayName("")
    @Test
    void saveBonusNumber() {
        // given
        int bonusNumber = 1;

        // when
        lottosRepository.saveBonusNumber(bonusNumber);
        int findBonusNumber = lottosRepository.findBonusNumber().get();

        // then
        assertThat(findBonusNumber).isEqualTo(bonusNumber);
    }
}