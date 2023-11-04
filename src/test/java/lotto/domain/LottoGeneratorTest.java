package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoGeneratorTest {
    LottoGenerator lottoGenerator = new LottoGenerator();
    long quantity;

    @DisplayName("로또 구입 개수에 해당하는 만큼의 로또를 발행한다.")
    @Test
    void generateLottos() {
        // given
        quantity = 5;

        // when
        Lottos lottos = lottoGenerator.generateLottos(quantity);

        // then
        assertThat(lottos.getLottos().size()).isEqualTo(quantity);
        System.out.println(lottos);
    }
}