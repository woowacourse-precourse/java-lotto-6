package lotto.service;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @DisplayName("로또 생성 테스트")
    @Test
    void checkNumberLength() {
        Generator<Lotto> generator = new LottoGenerator();
        assertThat(generator.generate().getClass())
                .isEqualTo(Lotto.class);
    }
}
