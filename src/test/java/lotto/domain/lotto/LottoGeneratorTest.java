package lotto.domain.lotto;

import java.util.List;
import lotto.domain.lotto.strategy.PickNumbersStrategy;
import lotto.domain.lotto.strategy.PickRandomNumbersStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("여러 개의 로또를 생성하였을 때 개수가 올바르게 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void generateLotteriesByCount(int count) {
        // given
        PickNumbersStrategy pickNumbersStrategy = new PickRandomNumbersStrategy();
        LottoGenerator lottoGenerator = new LottoGenerator(pickNumbersStrategy);

        // when
        List<Lotto> lotteries = lottoGenerator.generateByCount(count);
        int lotteriesCount = lotteries.size();

        // when & then
        Assertions.assertThat(lotteriesCount)
                .isEqualTo(count);
    }

}
