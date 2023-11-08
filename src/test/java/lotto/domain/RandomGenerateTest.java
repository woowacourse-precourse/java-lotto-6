package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RandomGenerateTest {
    private RandomGenerate randomGenerate;

    @BeforeEach
    void setUp() {
        randomGenerate = new RandomGenerate();
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "2", "3", "4", "5", "6"})
    void 로또_개수(int quantity) {
        List<List<Integer>> numbers = randomGenerate.createNumbers(quantity);
        assertThat(numbers.size()).isEqualTo(quantity);
    }
}