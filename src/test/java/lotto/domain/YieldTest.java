package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class YieldTest {

    @Test
    @DisplayName("수익률 계산 테스트")
    void yieldTest() {
        //given
        int amount = 5;
        Map<Ranking, Integer> rankingInfo = getRanking();

        //when
        Yield yield = Yield.from(rankingInfo, amount);

        //then
        assertThat(yield.getValue()).isEqualTo(61200);
    }

    private Map<Ranking, Integer> getRanking() {
        Map<Ranking, Integer> info = new EnumMap<>(Ranking.class);
        info.put(Ranking.FIFTH, 2);
        info.put(Ranking.FOURTH, 1);
        info.put(Ranking.THIRD, 2);
        info.put(Ranking.SECOND, 0);
        info.put(Ranking.FIRST, 0);
        return info;
    }
}
