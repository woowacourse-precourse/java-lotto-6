package lotto.service;

import lotto.model.LottoAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TotalReturnTest {
    @DisplayName("Ranking과 로또 수를 넣으면 총 이득율을 반환한다.")
    @Test
    void inputRankingAndLottoAmount() {
        assertThat(TotalReturn.getTotalReturnRate(new int[]{0, 0, 0, 0, 1, 1, 1, 0}, 10))
                .isEqualTo(315500.0);
    }
}
