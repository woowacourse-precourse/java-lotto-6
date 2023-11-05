package study;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class SourceTest {

    static Stream<List<Integer>> provideTestArrays() {
        return Stream.of(
                Arrays.asList(1, 2, 4),
                Arrays.asList(11, 12, 13)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestArrays")
    void testMethod(List<Integer> values) {
        Assertions.assertThat(values.size()).isEqualTo(3);
    }
}
