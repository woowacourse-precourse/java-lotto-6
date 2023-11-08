package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {

    @ParameterizedTest(name = "입력값 : [{0}, {1}], 기대값 : {2}")
    @MethodSource("provideDataForFind")
    @DisplayName("로또 순위 검색")
    void givenData_whenFindRank_thenReturnMatchedRank(int matchingCount, boolean bonusNumberExistence, Rank expected) {
        // when
        Rank result = Rank.find(matchingCount, bonusNumberExistence);

        // then
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> provideDataForFind() {
        return Stream.of(
                Arguments.of(6, false, Rank.FIRST),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(4, true, Rank.FOURTH),
                Arguments.of(4, false, Rank.FOURTH),
                Arguments.of(3, true, Rank.FIFTH),
                Arguments.of(3, false, Rank.FIFTH),
                Arguments.of(2, true, Rank.UNRANKED),
                Arguments.of(1, true, Rank.UNRANKED),
                Arguments.of(0, true, Rank.UNRANKED)
        );
    }

    @ParameterizedTest(name = "입력값 : {0}, 기대값 : {1}")
    @EnumSource(value = Rank.class, names = "UNRANKED")
    @DisplayName("순위가 없는지 확인: UNRANKED는 순위가 없음")
    void givenRank_whenIsUnranked_thenReturnTrue(Rank rank) {
        // when
        boolean result = rank.isUnranked();

        // then
        assertThat(result).isTrue();
    }

    @ParameterizedTest(name = "입력값 : {0}, 기대값 : {1}")
    @EnumSource(value = Rank.class, names = "UNRANKED", mode = Mode.EXCLUDE)
    @DisplayName("순위가 없는지 확인: UNRANKED 이외는 순위가 존재")
    void givenRank_whenIsUnranked_thenReturnFalse(Rank rank) {
        // when
        boolean result = rank.isUnranked();

        // then
        assertThat(result).isFalse();
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @EnumSource(value = Rank.class, names = "SECOND")
    @DisplayName("2등인지 확인: 2등이 맞으면 true")
    void givenRank_whenIsSecond_thenReturnTrue(Rank rank) {
        // when
        boolean result = rank.isSecond();

        // then
        assertThat(result).isTrue();
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @EnumSource(value = Rank.class, names = "SECOND", mode = Mode.EXCLUDE)
    @DisplayName("2등인지 확인: 2등이 아니면 false")
    void givenRank_whenIsSecond_thenReturnFalse(Rank rank) {
        // when
        boolean result = rank.isSecond();

        // then
        assertThat(result).isFalse();
    }

}
