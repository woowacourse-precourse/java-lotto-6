package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoFactoryTest {

    private final LottoFactory lottoFactory = new LottoFactory();

    @DisplayName("로또들이 제대로 생성되는지 확인하는 로직")
    @Test
    void createLottos() {
        Lottos lottos = lottoFactory.createLottos(2);
        assertThat(lottos.size()).isEqualTo(2);
    }

    @DisplayName("당첨 로또가 제대로 생성되는지 확인하는 테스트")
    @Test
    void createWinningLotto() {
        List<Integer> lottoNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningLotto winningLotto = lottoFactory.createWinningLotto(lottoNumber, bonusNumber);

        assertThat(winningLotto.getLottoNumber(0)).isEqualTo(1);
        assertThat(winningLotto.getLottoNumber(1)).isEqualTo(2);
        assertThat(winningLotto.getLottoNumber(2)).isEqualTo(3);
        assertThat(winningLotto.getLottoNumber(3)).isEqualTo(4);
        assertThat(winningLotto.getLottoNumber(4)).isEqualTo(5);
        assertThat(winningLotto.getLottoNumber(5)).isEqualTo(6);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(bonusNumber);
    }
}