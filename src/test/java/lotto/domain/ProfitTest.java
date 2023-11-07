package lotto.domain;

import java.util.EnumMap;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoRankInfo;
import lotto.model.Profit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProfitTest {


    @DisplayName("수익률 계산 float 정상 생성 테스트")
    @Test
    void calculateProfitRate_IsFloat_Success() {
        //given
        Profit profit = new Profit();
        Map<LottoRank, Integer> lottoRankInfo = new EnumMap(LottoRank.class);
        lottoRankInfo.put(LottoRank.NONE, 0);
        lottoRankInfo.put(LottoRank.FIFTH, 1);
        lottoRankInfo.put(LottoRank.FOURTH, 0);
        lottoRankInfo.put(LottoRank.THIRD, 0);
        lottoRankInfo.put(LottoRank.SECOND, 0);
        lottoRankInfo.put(LottoRank.FIRST, 0);

        //when
        float result = profit.calculateProfitRate(2000, lottoRankInfo);
        //then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(250.0f);

    }


}
