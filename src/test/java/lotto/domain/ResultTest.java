package lotto.domain;

import lotto.domain.constants.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

public class ResultTest {

    @ParameterizedTest
    @DisplayName("로또 수익금 계산")
    @MethodSource("resultWinningLottoAndProceeds")
    public void rateOfReturn(Result result, double proceeds) {
        Assertions.assertThat(result.proceeds()).isEqualTo(proceeds);
    }

    static Stream<Arguments> resultWinningLottoAndProceeds() {
        return Stream.of(
                Arguments.arguments(new HashMap<>(){{
                    put(LottoRank.FIRST, 1);
                    put(LottoRank.SECOND, 2);
                    put(LottoRank.THIRD, 0);
                    put(LottoRank.FOURTH, 0);
                    put(LottoRank.FIFTH, 0);
                    put(LottoRank.LOSE, 5);
                }}, 2060000000),
                Arguments.arguments(new HashMap<>(){{
                    put(LottoRank.FIRST, 0);
                    put(LottoRank.SECOND, 2);
                    put(LottoRank.THIRD, 0);
                    put(LottoRank.FOURTH, 0);
                    put(LottoRank.FIFTH, 0);
                    put(LottoRank.LOSE, 0);
                }}, 60000000),
                Arguments.arguments(new HashMap<>(){{
                    put(LottoRank.FIRST, 0);
                    put(LottoRank.SECOND, 0);
                    put(LottoRank.THIRD, 0);
                    put(LottoRank.FOURTH, 0);
                    put(LottoRank.FIFTH, 0);
                    put(LottoRank.LOSE, 5);
                }}, 0),
                Arguments.arguments(new HashMap<>(){{
                    put(LottoRank.FIRST, 0);
                    put(LottoRank.SECOND, 0);
                    put(LottoRank.THIRD, 0);
                    put(LottoRank.FOURTH, 0);
                    put(LottoRank.FIFTH, 5);
                    put(LottoRank.LOSE, 0);
                }}, 25000)
        );
    }
}
