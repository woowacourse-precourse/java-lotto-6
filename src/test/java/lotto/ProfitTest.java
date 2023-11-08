package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProfitTest {

    @ParameterizedTest
    @MethodSource("generateProfitData")
    void 맞은_갯수를_알아낸다(Rank rank, int rankCnt, double money, double expected) {

        Map<Rank, Integer> result = new HashMap<>();
        for (Rank r : Rank.values()){
            result.put(r, 0);
        }
        result.put(rank, rankCnt);

        Profit profit = new Profit(result, money);
        assertThat(profit.profitRate).isEqualTo(expected);
    }

    static Stream<Arguments> generateProfitData(){
        return Stream.of(
                Arguments.of("FIFTH", 1, 8000, 62.5)
        );
    }
}