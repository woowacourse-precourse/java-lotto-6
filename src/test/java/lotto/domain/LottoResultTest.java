package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    LottoResult lottoResult;
    RateOfReturn rateOfReturn;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult(new ArrayList<>(List.of(1,2,3,4,5,6)), 7, new ArrayList<>(Arrays.asList(new ArrayList<>(List.of(2, 3, 4, 11, 33, 41)), new ArrayList<>(List.of(1, 2, 3, 40, 41, 42)))));
        rateOfReturn = new RateOfReturn();
    }

    @DisplayName("사용자가 구매한 로또 번호와 당첨 번호를 비교한다.")
    @Test
    void getLottoResult() {
        Map<Rank, Integer> prizeCount = lottoResult.compare();
        assertThat(prizeCount.get(Rank.FIFTH)).isEqualTo(2);
    }

    @DisplayName("수익률 계산하기")
    @Test
    void getRateOfReturn() {
        Map<Rank, Integer> prizeCount = lottoResult.compare();
        double rate = rateOfReturn.getRateOfReturn(8000, prizeCount);
        assertThat(rate).isEqualTo(125.0);
    }
}
