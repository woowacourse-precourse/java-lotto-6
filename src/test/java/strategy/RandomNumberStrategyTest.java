package strategy;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.domain.LottoConfig;
import lotto.domain.generator.strategy.RandomNumberStrategy;
import org.junit.jupiter.api.Test;

public class RandomNumberStrategyTest {

    RandomNumberStrategy strategy = new RandomNumberStrategy();
    int count = LottoConfig.NUMBER_COUNT.getValue();
    int min = LottoConfig.MIN_NUMBER.getValue();
    int max = LottoConfig.MAX_NUMBER.getValue();

    @Test
    public void testValueRange() {
        List<Integer> numbers = strategy.generateNumbers(count, min, max);
        assertThat(numbers).allMatch(number -> number >= min && number <= max);
    }

    @Test
    public void testNoDuplication() {
        List<Integer> numbers = strategy.generateNumbers(count, min, max);
        assertThat(numbers).doesNotHaveDuplicates();
    }

    @Test
    public void testCorrectSize() {
        List<Integer> numbers = strategy.generateNumbers(count, min, max);
        assertThat(numbers).hasSize(count);
    }

}
