package lotto.purchasing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class GeneratorTest {

    @Test
    public void uniqueNumbersInAscendingOrder() {
        Generator generator = new Generator(new PurchaseAmount());

        List<Integer> mockLotto =
                generator.issue(1, 1, 6, 6).get(0).getNumbers();

        assertThat(mockLotto).isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }
}