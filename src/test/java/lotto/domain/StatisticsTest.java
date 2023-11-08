package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsTest {
    @Test
    @DisplayName("수익률을 계산한다.")
    void calculateRate() {
        //given
        int money = 1000;
        Map<Prize, Integer> prizeResults = new EnumMap<>(Prize.class);
        prizeResults.put(Prize.THIRD, 1);
        prizeResults.put(Prize.SECOND, 2);

        Statistics statistics = new Statistics(prizeResults);

        // when
        double rate = statistics.calculate(money);

        // then
        assertEquals(6150000, rate);
    }
}