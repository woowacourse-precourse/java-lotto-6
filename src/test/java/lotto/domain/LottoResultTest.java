package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    @DisplayName("getTotalPrize 메서드 테스트")
    public void testGetTotalPrize() {
        Map<Rank, Integer> result = new HashMap<>();
        result.put(Rank.FIRST, 1); // 1등 1개, 총 2,000,000,000원
        result.put(Rank.SECOND, 2); // 2등 2개, 총 60,000,000원
        result.put(Rank.THIRD, 3); // 3등 3개, 총 4,500,000원

        LottoResult lottoResult = new LottoResult(result);

        assertThat(lottoResult.getTotalPrize()).isEqualTo(2_064_500_000);
    }

    @Test
    @DisplayName("getResult 메서드 테스트")
    public void testGetResult() {
        Map<Rank, Integer> result = new HashMap<>();
        result.put(Rank.FIRST, 1);
        result.put(Rank.SECOND, 2);
        result.put(Rank.THIRD, 3);

        LottoResult lottoResult = new LottoResult(result);

        assertThat(lottoResult.getResult()).isEqualTo(result);
    }
}
