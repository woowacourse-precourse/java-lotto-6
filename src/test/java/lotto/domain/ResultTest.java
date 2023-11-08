package lotto.domain;

import static lotto.constants.Constants.LOTTO_COST;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import lotto.constants.Ranks;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ResultTest {

    @ParameterizedTest
    @DisplayName("이익률을 계산할 수 있다.")
    @MethodSource("calculateProfitPercentTestValue")
    void calculateProfitPercentTest(Ranks rank, int amount, int costNumber) {
        //given
        Map<Ranks, Integer> rankResult = new HashMap<>();
        rankResult.put(rank, amount);
        Cost cost = new Cost(costNumber);
        Result result = new Result(rankResult);
        //
        Assertions.assertThat(result.calculateProfitPercent(cost)).isEqualTo(rank.getPrize() / LOTTO_COST * 100);
    }

    private static Stream<Arguments> calculateProfitPercentTestValue() {
        return Stream.of(
                Arguments.of(Ranks.THREE_MATCH, 1, 1000),
                Arguments.of(Ranks.FOUR_MATCH, 1, 1000)
        );
    }

}
