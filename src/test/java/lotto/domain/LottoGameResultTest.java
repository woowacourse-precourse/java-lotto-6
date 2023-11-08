package lotto.domain;

import lotto.constant.LottoRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameResultTest {

    @DisplayName("로또 수익률을 제대로 계산하는지 테스트")
    @Test
    void calculateRewardTest() {
        LottoGameResult lottoGameResult = new LottoGameResult();

        int investAmount = 10000; // 원금
        lottoGameResult.add(LottoRank.FOURTH); // 상금 : 5만원

        double profitRate = lottoGameResult.calculateProfitRate(investAmount);
        assertThat(profitRate).isEqualTo(500.0);

        lottoGameResult.add(LottoRank.FIFTH);
        lottoGameResult.add(LottoRank.FIFTH); // 상금 : 6만원

        double profitRate2 = lottoGameResult.calculateProfitRate(investAmount);
        assertThat(profitRate2).isEqualTo(600.0);
    }
    
    @DisplayName("로또 등수에 맞는 인원을 제대로 불러오는지 테스트")
    @Test
    void getNumberOfRank() {
        LottoGameResult lottoGameResult = new LottoGameResult();

        int count = 5;
        for (int i = 0; i < count; i ++) {
            lottoGameResult.add(LottoRank.FIFTH);
        }

        int numberOfFIFTH = lottoGameResult.getNumberOfRank(LottoRank.FIFTH);
        assertThat(numberOfFIFTH).isEqualTo(count);
    }
}