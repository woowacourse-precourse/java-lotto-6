package lotto.domain.lotto;

import lotto.domain.lotto.strategy.PickNumbersStrategy;
import lotto.domain.lotto.strategy.PickRandomNumbersStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    @DisplayName("PickRandomNumbers 전략을 사용하여 로또를 생성하였을 때 예외가 발생하지 않는다.")
    @Test
    void generateLottoWithPickRandomNumbersStrategy() {
        // given
        PickNumbersStrategy pickNumbersStrategy = new PickRandomNumbersStrategy();
        LottoGenerator lottoGenerator = new LottoGenerator(pickNumbersStrategy);

        // when & then
        Assertions.assertThatCode(lottoGenerator::generate)
                .doesNotThrowAnyException();
    }

}
