package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.EnumMap;
import lotto.constant.LottoResultRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("WinningStatistic의")
class WinningStatisticTest {

    @Test
    @DisplayName("최종 수익을 반환하는가")
    void get_total_Prize() {
        //given
        final Integer expectedTotalPrize = 1555000;
        final EnumMap<LottoResultRule, Integer> elements = new EnumMap<>(LottoResultRule.class);
        elements.put(LottoResultRule.THREE_MATCH, 1);
        elements.put(LottoResultRule.FOUR_MATCH, 1);
        elements.put(LottoResultRule.FIVE_MATCH, 1);
        final WinningStatistic winningStatistic = new WinningStatistic(elements);

        //when
        final Integer totalPrize = winningStatistic.getTotalPrize();

        //then
        assertThat(totalPrize).isEqualTo(expectedTotalPrize);
    }
}
