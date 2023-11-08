package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoFactoryTest {

    private final LottoFactory lottoFactory = new LottoFactory();

    @DisplayName("로또들이 제대로 생성되는지 확인하는 로직")
    @Test
    void createLottos() {
        Lottos lottos = lottoFactory.createLottos(2);
        Assertions.assertThat(lottos.size()).isEqualTo(2);
    }

    @Test
    void createWinningLotto() {

    }
}