package lotto.application;

import static lotto.domain.LottoConfig.LOTTO_COUNT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {
    private final NumberGenerator numberGenerator = new RandomNumberGenerator();

    @Test
    void 개수만큼_랜덤_숫자를_생성하여_반환한다() {
        // given
        final int count = LOTTO_COUNT.getValue();

        // when
        List<Integer> numbers = numberGenerator.generateNumbers(count);

        // then
        assertThat(numbers).hasSize(count);
    }
}
