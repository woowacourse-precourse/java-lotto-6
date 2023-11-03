package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoStoreTest {

    @Test
    @DisplayName("로또 구입 금액에 해당하는 만큼 로또를 발행할 수 있다.")
    void buyLotto() {
        List<Lotto> lottos = LottoStore.buyLotto(2000);

        assertThat(lottos.size()).isEqualTo(2);
    }
}