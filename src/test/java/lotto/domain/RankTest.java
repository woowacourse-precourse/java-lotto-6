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
    void 당첨번호와의_일치개수로_등수를_결정한다(Integer 일치개수, boolean 보너스번호여부, String 등수이름) {
        // when
        Rank 등수 = Rank.determineByMatchingCount(일치개수, 보너스번호여부);

        // then
        assertEquals(등수이름, 등수.name());
    }

    static Stream<Arguments> 당첨번호와의_일치개수_설정() {
        return Stream.of(
            Arguments.arguments(6, false, "FIRST"),
            Arguments.arguments(5, true, "SECOND"),
            Arguments.arguments(5, false, "THIRD"),
            Arguments.arguments(4, false, "FOURTH"),
            Arguments.arguments(3, false, "FIFTH"),
            Arguments.arguments(0, false, "UNRANKED")
        );
    }
}