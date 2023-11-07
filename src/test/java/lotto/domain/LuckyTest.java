package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class LuckyTest {

    Lucky computer = new Lucky(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

    @ParameterizedTest(name = "로또 번호:{0}, 결과: {1}")
    @MethodSource("lottoRank")
    @DisplayName("로또 번호의 당첨여부를 확인한다. 당첨번호:[1,2,3,4,5,6], 보너스:7")
    void 등수_확인(List<Integer> number, Rank rank) {
        Lotto lotto = new Lotto(number);
        Assertions.assertThat(computer.checkWinning(lotto)).isEqualTo(rank);
    }

    static Stream<Arguments> lottoRank() {
        return Stream.of(
                Arguments.arguments(Arrays.asList(1, 2, 3, 4, 5, 6), Rank.FIRST),
                Arguments.arguments(Arrays.asList(1, 2, 3, 4, 5, 7), Rank.SECOND),
                Arguments.arguments(Arrays.asList(1, 2, 3, 4, 5, 8), Rank.THIRD),
                Arguments.arguments(Arrays.asList(1, 2, 3, 4, 8, 9), Rank.FOURTH),
                Arguments.arguments(Arrays.asList(1, 2, 3, 11, 12, 13), Rank.FIFTH)
        );
    }
}