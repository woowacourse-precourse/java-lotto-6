package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ValidateUtilTest {

    @Test
    void stringToArrayList() {
        List<Integer> expectedOutput = Arrays.asList(1, 3, 4, 5);
        List<Integer> numbers = ValidateUtil.stringToArrayList("1,3 , 4,5");
        assertThat(numbers)
                .isEqualTo(expectedOutput);

        expectedOutput = Arrays.asList(1, 4, 5);
        numbers = ValidateUtil.stringToArrayList("1,4,5");
        assertThat(numbers)
                .isEqualTo(expectedOutput);

    }
}