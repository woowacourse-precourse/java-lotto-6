package lotto.utils;

import lotto.domain.Lottos;
import lotto.utils.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    @DisplayName("로또 구입 개수에 해당하는 만큼의 로또를 발행한다.")
    @Test
    void generateLottos() {
        // given
        long quantity = 5;

        // when
        Lottos lottos = LottoGenerator.generateLottos(quantity);

        // then
        assertThat(lottos.getLottos().size()).isEqualTo(quantity);
    }
}