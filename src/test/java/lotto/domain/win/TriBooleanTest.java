package lotto.domain.win;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TriBooleanTest {

    @DisplayName("2개의 TriBoolean이 주어졌을 때, 동등성을 판단할 수 있다.")
    @ParameterizedTest
    @MethodSource("ProvideTriBooleanAndExpectedResult")
    void triBooleanEqualsTest(TriBoolean triBoolean1, TriBoolean triBoolean2, boolean expectedIsEquals) {
        // when
        boolean isEquals = triBoolean1.equals(triBoolean2);

        // then
        Assertions.assertThat(isEquals)
                .isEqualTo(expectedIsEquals);
    }

    private static Stream<Arguments> ProvideTriBooleanAndExpectedResult() {
        return Stream.of(
                Arguments.of(TriBoolean.TRUE, TriBoolean.TRUE, true),
                Arguments.of(TriBoolean.TRUE, TriBoolean.FALSE, false),
                Arguments.of(TriBoolean.TRUE, TriBoolean.WHATEVER, true),
                Arguments.of(TriBoolean.FALSE, TriBoolean.TRUE, false),
                Arguments.of(TriBoolean.FALSE, TriBoolean.FALSE, true),
                Arguments.of(TriBoolean.FALSE, TriBoolean.WHATEVER, true),
                Arguments.of(TriBoolean.WHATEVER, TriBoolean.TRUE, true),
                Arguments.of(TriBoolean.WHATEVER, TriBoolean.FALSE, true),
                Arguments.of(TriBoolean.WHATEVER, TriBoolean.WHATEVER, true)
        );
    }

}
