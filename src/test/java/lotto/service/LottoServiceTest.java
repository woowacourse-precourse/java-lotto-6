package lotto.service;

import java.util.Map;
import lotto.domain.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @Test
    void getRewardRatio() {
        //given
        int purchaseAmount = 18000;
        Map<Prize, Integer> prizeMap = Map.of(
                Prize.FIRST_REWARD, 0
                , Prize.SECOND_REWARD, 0
                , Prize.THIRD_REWARD, 0
                , Prize.FOURTH_REWARD, 0
                , Prize.FIFTH_REWARD, 2);

        //when
        double rewardRatio = lottoService.getRewardRatio(purchaseAmount, prizeMap);
        //then
        Assertions.assertThat(rewardRatio).isEqualTo(55.6);
    }
}