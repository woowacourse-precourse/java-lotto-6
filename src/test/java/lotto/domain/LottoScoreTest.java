package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoScoreTest {
    private static Stream<Arguments> provideLottoScoreAndWinner() {
        return Stream.of(
                Arguments.of(new LottoScore(6, false), Winner.FRIST),
                Arguments.of(new LottoScore(5, true), Winner.SECOND),
                Arguments.of(new LottoScore(5, false), Winner.THIRD),
                Arguments.of(new LottoScore(4, false), Winner.FOURTH),
                Arguments.of(new LottoScore(3, false), Winner.FIFTH)
        );
    }

    @ParameterizedTest
    @MethodSource("provideLottoScoreAndWinner")
    void LottoScore를_Winner를_반환한다(LottoScore lottoScore, Winner winner) {
        assertEquals(winner, lottoScore.getWinners());
    }


}