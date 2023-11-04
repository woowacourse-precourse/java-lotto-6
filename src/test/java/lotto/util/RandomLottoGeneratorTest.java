package lotto.util;

import lotto.model.lottogenerator.LottoGenerator;
import lotto.model.lottogenerator.RandomLottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLottoGeneratorTest {

    LottoGenerator generator = new RandomLottoGenerator();

    @Test
    @DisplayName("로또가 정상적으로 생성됨")
    public void 정상_동작() throws Exception{
        Assertions.assertThatNoException()
                .isThrownBy(() -> generator.generate());
    }

}