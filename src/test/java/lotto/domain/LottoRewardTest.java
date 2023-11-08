package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRewardTest {
    static final int LOTTO_1ST_PRICE = 2000000000;
    @DisplayName("로또 통계를 받아 당첨금의 합을 반환한다.")
    @Test
    void getLottoReward() {
        LottoStatistic lottoStatistic = new LottoStatistic(
                List.of(new LottoResult(6, false)));
        LottoReward lottoReward = new LottoReward(lottoStatistic);

        assertThat(lottoReward.claim())
                .isEqualTo(2000000000);
    }
}
