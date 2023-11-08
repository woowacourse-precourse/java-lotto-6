package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {
    @DisplayName("생성된 로또 개수가 예상 했던 개수와 일치한다.")
    @Test
    void testLottosCountIsTrue() {
        Integer expectedCount = 3;

        Lottos lottos = NumberGenerator.createLottos(expectedCount);

        assertThat(lottos.getLottos().size()).isEqualTo(expectedCount);
    }
}