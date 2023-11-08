package lotto.util;

import lotto.model.domain.lotto.lottogenerator.LottoGenerator;
import lotto.model.domain.lotto.lottogenerator.RandomLottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLottoGeneratorTest {

    private final LottoGenerator generator = new RandomLottoGenerator();

    @Test
    @DisplayName("로또가 정상적으로 생성됨")
    public void 정상_동작() {
        Assertions.assertThatNoException()
                .isThrownBy(generator::generate);
    }

}