package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {

    @ParameterizedTest
    @MethodSource("Rank를_맞출_수_있다_파라미터")
    void Rank를_맞출_수_있다(int matchNumberCount, boolean matchBonusNumber, Rank expected) {
        // given
        Rank actual = Rank.of(matchNumberCount, matchBonusNumber);

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> Rank를_맞출_수_있다_파라미터() {
        return Stream.of(
                Arguments.of(6, false, Rank.FIRST),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(5, false, Rank.THIRD)
        );
    }

}