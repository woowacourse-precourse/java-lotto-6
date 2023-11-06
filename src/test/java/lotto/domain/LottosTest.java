package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {
    @Test
    @DisplayName("로또 리스트 생성 성공")
    public void createLottos() {
        // given
        int count = 5;
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> createdLotto = lottoMachine.createAllLotto(count);

        // when
        Lottos lottos = new Lottos(createdLotto);

        // then
        assertThat(lottos).isNotNull();
    }
}