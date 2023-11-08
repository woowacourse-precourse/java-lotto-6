package domain;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;


import lotto.config.RankConfig;
import lotto.domain.LottoGameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGameResultTest {

    private static LottoGameResult lottoResult;

    @DisplayName("로또 당첨 결과를 저장하는 기능 테스트")
    @Test
    void storeGameResult(){
        lottoResult = new LottoGameResult();
        initResult();
        assertThat(lottoResult.getLottoResult()).contains(
                entry(RankConfig.FIRST, 1),
                entry(RankConfig.SECOND, 1),
                entry(RankConfig.THIRD, 1),
                entry(RankConfig.FOURTH, 1),
                entry(RankConfig.FIFTH, 1)
        );
    }

    @DisplayName("로또 당첨 총 상금 계산하는 기능 테스트")
    @Test
    void getPrizeSum(){
        lottoResult = new LottoGameResult();
        initResult();
        assertThat(lottoResult.getPrizeSum()).isEqualTo(2031555000);
    }

    void initResult(){
        lottoResult.setLottoResult(RankConfig.FIRST);
        lottoResult.setLottoResult(RankConfig.SECOND);
        lottoResult.setLottoResult(RankConfig.THIRD);
        lottoResult.setLottoResult(RankConfig.FOURTH);
        lottoResult.setLottoResult(RankConfig.FIFTH);
    }
}
