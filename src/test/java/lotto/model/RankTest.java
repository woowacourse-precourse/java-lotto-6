package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RankTest {

    @DisplayName("일치하는 번호의 수를 비교하여 당첨 등수를 알 수 있다.")
    @ParameterizedTest
    @MethodSource("rankData")
    void calculate(int matchCount, boolean hasBonusNumber, Rank rank){
        assertThat(Rank.calculate(matchCount, hasBonusNumber)).isEqualTo(rank);
    }

    static Stream<Arguments> rankData() {
        return Stream.of(
                arguments(6, false, Rank.FIRST_PLACE),
                arguments(5, true, Rank.SECOND_PLACE),
                arguments(5, false, Rank.THIRD_PLACE),
                arguments(4, true, Rank.FOURTH_PLACE),
                arguments(4, false, Rank.FOURTH_PLACE),
                arguments(3, true, Rank.FIFTH_PLACE),
                arguments(3, false, Rank.FIFTH_PLACE),
                arguments(2, true, Rank.LAST_PLACE),
                arguments(2, false, Rank.LAST_PLACE),
                arguments(1, true, Rank.LAST_PLACE),
                arguments(1, false, Rank.LAST_PLACE),
                arguments(0, true, Rank.LAST_PLACE),
                arguments(0, false, Rank.LAST_PLACE)
        );
    }

}