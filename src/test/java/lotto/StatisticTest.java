package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class StatisticTest {
    @ParameterizedTest
    @CsvSource({"0,false,0", "1,false,0", "2,false,0", "3,false,5", "4,false,4", "5,false,3", "5,true,2", "6,false,1"})
    void getRankTest(int numOfMatch, boolean isBonus, int rank) {
        assertThat(Statistic.getRank(numOfMatch, isBonus)).isEqualTo(rank);
    }

    @Test
    void getPrizeTest() {
        assertThat(Statistic.getPrize()).isEqualTo(List.of(2000000000, 30000000, 1500000, 50000, 5000));
    }
}