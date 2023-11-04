package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLottoGeneratorTest {

    LottoGenerator generator = new RandomLottoGenerator();

    @Test
    @DisplayName("로또가 정상적으로 생성됨")
    public void 정상_동작() throws Exception{
        Assertions.assertThatNoException()
                .isThrownBy(() -> generator.generateNumbers());
    }

}