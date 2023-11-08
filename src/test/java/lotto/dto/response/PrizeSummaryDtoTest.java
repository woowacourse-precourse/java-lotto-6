package lotto.dto.response;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;
import lotto.model.LottoPrize;
import lotto.model.PrizeSummary;

class PrizeSummaryDtoTest {

    @Test
    void 당첨_내역_출력을_위한_데이터는_상금이_0원인_당첨_내역은_포함하지_않는다() {
        Map<LottoPrize, Long> summary = Map.of(
                LottoPrize.FIRST_PRIZE, 1L,
                LottoPrize.SECOND_PRIZE, 1L,
                LottoPrize.THIRD_PRIZE, 1L,
                LottoPrize.FOURTH_PRIZE, 1L,
                LottoPrize.FIFTH_PRIZE, 1L,
                LottoPrize.NOTHING, 3L
        );
        PrizeSummary prizeSummary = PrizeSummary.from(summary);

        PrizeSummaryDto prizeSummaryDto = PrizeSummaryDto.from(prizeSummary.getSummary());

        assertThat(prizeSummaryDto.getPrizeSummary())
                .doesNotContainKey(LottoPrize.NOTHING);
    }

    @Test
    void 당첨_내역_출력을_위한_데이터는_상금이_낮은_순서에서_높은_순서로_정렬되어_있다() {
        Map<LottoPrize, Long> summary = Map.of(
                LottoPrize.FIRST_PRIZE, 1L,
                LottoPrize.SECOND_PRIZE, 1L,
                LottoPrize.THIRD_PRIZE, 1L,
                LottoPrize.FOURTH_PRIZE, 1L,
                LottoPrize.FIFTH_PRIZE, 1L
        );
        PrizeSummary prizeSummary = PrizeSummary.from(summary);

        PrizeSummaryDto prizeSummaryDto = PrizeSummaryDto.from(prizeSummary.getSummary());

        Set<LottoPrize> actualLottoPrizeKey = prizeSummaryDto.getPrizeSummary().keySet();
        assertThat(actualLottoPrizeKey).containsExactly(
                LottoPrize.FIFTH_PRIZE,
                LottoPrize.FOURTH_PRIZE,
                LottoPrize.THIRD_PRIZE,
                LottoPrize.SECOND_PRIZE,
                LottoPrize.FIRST_PRIZE
        );
    }
}
