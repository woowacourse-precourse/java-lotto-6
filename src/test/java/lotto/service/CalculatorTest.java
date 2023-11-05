package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.Rank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class CalculatorTest {
    Calculator calculator = new Calculator();
    @ParameterizedTest
    @EnumSource(
            value = Rank.class,
            names = {"FIRST", "SECOND", "THIRD", "FORTH", "FIFTH"})
    void 계산기_단위_테스트(Rank givenRank) {
        //given
        Map<Rank, Integer> map = new HashMap<>();
        map.put(givenRank, 1);
        int pay = 1000;

        //when
        double value = calculator.calculateRateOfReturn(map, pay);

        //then
        assertThat(value).isEqualTo(givenRank.reward * 100 / pay);
    }

    @Test
    void 계산기_종합_테스트() {
        //given
        Map<Rank, Integer> map = new HashMap<>();
        map.put(Rank.FIFTH, 2);
        map.put(Rank.SECOND, 1);
        int pay = 3000;

        //when
        double value = calculator.calculateRateOfReturn(map, pay);

        //then
        long sum = (Rank.FIFTH.reward * 2) + (Rank.SECOND.reward);
        assertThat(value).isEqualTo((double) sum * 100 / pay);
    }
}
