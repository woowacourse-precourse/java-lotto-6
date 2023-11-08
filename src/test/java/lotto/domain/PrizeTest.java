package lotto.domain;

import static lotto.domain.PrizeRankConstants.RANK_1ST;
import static lotto.domain.PrizeRankConstants.RANK_3RD;
import static lotto.domain.PrizeRankConstants.RANK_5TH;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {

    @DisplayName("총 상금액을 정확하게 구해내는 가?")
    @Test
    void checkTotalPrizeAmount() {
        Prize prize = new Prize();
        PrizeRankConstants rank = RANK_1ST;

        prize.increaseCountOf(RANK_1ST);
        prize.increaseCountOf(RANK_3RD);
        prize.increaseCountOf(RANK_5TH);

        Integer totalAmount = prize.getTotalPrizeAmount();;
        assertThat(totalAmount.equals(2_001_505_000));
    }
}