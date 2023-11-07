package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottosTest {
    @DisplayName("생성할 로또 갯수를 입력받아 로또를 생성한다.")
    @Test
    void createLottos() {
        Lottos lottos = new Lottos(5);
        assertThat(lottos.getLottos().size()).isEqualTo(5);
    }

    @DisplayName("생성한 로또들을 모두 비교하여 결과를 반환한다.")
    @Test
    void checkAllLotto() {
        Lottos lottos = new Lottos(5);
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(lottos.matchAllLotto(winningLotto).size()).isEqualTo(5);
    }
}