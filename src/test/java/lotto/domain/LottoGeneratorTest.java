package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @Test
    @DisplayName("입력된 크기만큼 로또를 만들 수 있다.")
    void createLottos() {
        List<Lotto> lottos = LottoGenerator.createLottos(5);
        assertThat(lottos.size()).isEqualTo(5);
    }
}