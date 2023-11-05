package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {
    @ParameterizedTest
    @MethodSource("당첨번호와의_일치개수_설정")
    void 당첨번호와의_일치개수로_등수를_결정한다(Integer 일치개수, Integer 보너스일치개수, String 등수이름) {
        // when
        Rank 등수 = Rank.determineByMatchingCount(일치개수, 보너스일치개수);

        // then
        assertEquals(등수이름, 등수.name());
    }

    static Stream<Arguments> 당첨번호와의_일치개수_설정() {
        return Stream.of(
            Arguments.arguments(6, 0, "FIRST"),
            Arguments.arguments(5, 1, "SECOND"),
            Arguments.arguments(5, 0, "THIRD"),
            Arguments.arguments(4, 0, "FOURTH"),
            Arguments.arguments(3, 0, "FIFTH"),
            Arguments.arguments(0, 0, "UNRANKED")
        );
    }
}