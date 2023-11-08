package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PriceTest {

    static Stream<Arguments> provideScore() {
        return Stream.of(
            Arguments.of(6, Price.FIRST),
            Arguments.of(5, Price.SECOND),
            Arguments.of(4, Price.FORTH),
            Arguments.of(3, Price.FIFTH)
        );
    }

    @DisplayName("당첨 번호 개수가 {0} 개 라면, Price.{1} 객체를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideScore")
    void checkPriceByScore(int score, Price price) {
        assertThat(Price.findByScore(score)).isEqualTo(price);
    }
}