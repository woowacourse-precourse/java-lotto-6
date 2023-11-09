package lotto.domain;

import lotto.domain.constants.LottoRank;
import lotto.domain.constants.LottoRule;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @DisplayName("로또 구매금액 계산")
    @Test
    public void calculateBuyLottoAmount() {
        Result result = new Result(new HashMap<>(){{
            put(LottoRank.FIRST, 1);
            put(LottoRank.SECOND, 2);
            put(LottoRank.THIRD, 0);
            put(LottoRank.FOURTH, 0);
            put(LottoRank.FIFTH, 0);
            put(LottoRank.LOSE, 5);
        }});

        Assertions.assertThat(result.totalBuyLottoAmount()).isEqualTo(8000);
    }

    @DisplayName("로또 수익률 계산")
    @Test
    public void calculateLottoRateOfReturn() {
        int lottoCount = 8;
        double buyLottoAmount = lottoCount * LottoRule.PRICE.getValue();
        Map<LottoRank, Integer> ranks = new HashMap<>(){{
            put(LottoRank.FIRST, 0);
            put(LottoRank.SECOND, 0);
            put(LottoRank.THIRD, 0);
            put(LottoRank.FOURTH, 0);
            put(LottoRank.FIFTH, 1);
            put(LottoRank.LOSE, 7);
        }};
        double totalWinningAmount = ranks.entrySet()
                .stream()
                .mapToDouble(result -> result.getKey().getWinningAmount() * result.getValue())
                .sum();
        Result result = new Result(ranks);

        Assertions.assertThat(result.calculateLottoRateOfReturn()).isEqualTo((totalWinningAmount / buyLottoAmount) * 100);
    }

    static Stream<Arguments> resultWinningLottoAndProceeds() {
        return Stream.of(
                Arguments.arguments(new Result(new HashMap<>(){{
                    put(LottoRank.FIRST, 1);
                    put(LottoRank.SECOND, 2);
                    put(LottoRank.THIRD, 0);
                    put(LottoRank.FOURTH, 0);
                    put(LottoRank.FIFTH, 0);
                    put(LottoRank.LOSE, 5);
                }}), 2060000000),
                Arguments.arguments(new Result(new HashMap<>(){{
                    put(LottoRank.FIRST, 0);
                    put(LottoRank.SECOND, 2);
                    put(LottoRank.THIRD, 0);
                    put(LottoRank.FOURTH, 0);
                    put(LottoRank.FIFTH, 0);
                    put(LottoRank.LOSE, 0);
                }}), 60000000),
                Arguments.arguments(new Result(new HashMap<>(){{
                    put(LottoRank.FIRST, 0);
                    put(LottoRank.SECOND, 0);
                    put(LottoRank.THIRD, 0);
                    put(LottoRank.FOURTH, 0);
                    put(LottoRank.FIFTH, 0);
                    put(LottoRank.LOSE, 5);
                }}), 0),
                Arguments.arguments(new Result(new HashMap<>(){{
                    put(LottoRank.FIRST, 0);
                    put(LottoRank.SECOND, 0);
                    put(LottoRank.THIRD, 0);
                    put(LottoRank.FOURTH, 0);
                    put(LottoRank.FIFTH, 5);
                    put(LottoRank.LOSE, 0);
                }}), 25000)
        );
    }
}
