package lotto.domain;

import static lotto.constants.LottoPrize.FIRST;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    @DisplayName("랭크를 저장하면 랭크의 갯수와 값이 증가한다.")
    @Test
    void saveRank() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.save(FIRST);
        int countResult = lottoResult.getStatus().get(FIRST);
        double priceResult = lottoResult.getTotalPrice();

        assertThat(countResult).isEqualTo(1);
        assertThat(priceResult).isEqualTo(2_000_000_000);
    }


    @DisplayName("구매금액대비 수익률을 계산해준다")
    @Test
    void caculateEarningRateTest() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.save(FIRST);
        double earningRate = lottoResult.calculateEarningRate(1000);

        assertThat(earningRate).isEqualTo(200_000_000);
    }
}