package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomGenerateTest {
    private RandomGenerate randomGenerate;
    private static final int QUANTITY = 3;

    @BeforeEach
    void setUp() {
        randomGenerate = new RandomGenerate();
    }

    @Test
    void 로또_개수() {
        List<List<Integer>> numbers = randomGenerate.createNumbers(QUANTITY);
        assertThat(numbers.size()).isEqualTo(QUANTITY);
    }
}