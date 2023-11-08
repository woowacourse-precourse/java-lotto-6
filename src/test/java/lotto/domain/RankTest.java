package lotto.domain;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RankTest {

    @DisplayName("조건에 맞는 RANK를 생성함")
    @ParameterizedTest
    @MethodSource("generate")
    void createRankTest(Rank createRank, Rank rank) {
        Assertions.assertEquals(rank, createRank);
    }

    static Stream<Arguments> generate() {
        return Stream.of(
                Arguments.of(Rank.from(2, true), Rank.BLANK),
                Arguments.of(Rank.from(3, true), Rank.FIFTH),
                Arguments.of(Rank.from(4, true), Rank.FOURTH),
                Arguments.of(Rank.from(5, false), Rank.THIRD),
                Arguments.of(Rank.from(5, true), Rank.SECOND),
                Arguments.of(Rank.from(6, true), Rank.FIRST)
        );
    }
}
