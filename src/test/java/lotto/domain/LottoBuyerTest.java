package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoBuyerTest {

    @Test
    @DisplayName("수익률을 구한다.")
    void testGetRateOfRevenue() {
        LottoBuyer lottoBuyer = new LottoBuyer(new Payment(10000));
        List<LottoRank> lottoRanks = new ArrayList<>(List.of(LottoRank.FOURTH));

        double result = lottoBuyer.getRateOfReturn(lottoRanks);
        double expected = 500.0;

        assertThat(result).isEqualTo(expected);
    }
}
