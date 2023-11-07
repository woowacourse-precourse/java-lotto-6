package lotto.purchasing;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GeneratorTest {
    String mockInput = "1000";

    @BeforeEach
    public void setUpStreams() {
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));
    }

    @AfterEach
    public void restoreStreams() {
        System.setIn(System.in);
        Console.close();
    }

    @Test
    public void uniqueNumbersInAscendingOrder() {
        Generator generator = new Generator(new PurchaseAmount().ask());

        List<Integer> mockLotto =
                generator.issue(1, 6, 6).get(0).getNumbers();

        assertThat(mockLotto).isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }
}