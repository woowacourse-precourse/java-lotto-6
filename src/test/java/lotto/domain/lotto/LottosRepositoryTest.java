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
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningLotto winningLotto = WinningLotto.createFrom(lottoNumbers, bonusNumber);

        // when
        lottosRepository.saveWinningLotto(winningLotto);
        WinningLotto findWinningLotto = lottosRepository.findWinningLotto().get();

        // then
        assertThat(findWinningLotto).isEqualTo(winningLotto);
    }
}