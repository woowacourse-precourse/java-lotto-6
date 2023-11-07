package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


class StatisticTest {
    @ParameterizedTest
    @CsvSource({"0,false,0", "1,false,0", "2,false,0", "3,false,5", "4,false,4", "5,false,3", "5,true,2", "6,false,1"})
    void getRankTest(int numOfMatch, boolean isBonus, int rank) {
        assertThat(Statistic.getRank(numOfMatch, isBonus)).isEqualTo(rank);
    }
}