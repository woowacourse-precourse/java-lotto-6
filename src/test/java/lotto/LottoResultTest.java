package lotto;

import java.util.Arrays;
import lotto.model.LottoRank;
import lotto.model.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoResultTest {

    @DisplayName("초기화 확인하기")
    @Test
    void InitializeTest(){
        LottoResult lottoResult = new LottoResult();
        assertThat(Arrays.stream(LottoRank.values())
                .map(lottoResult::getRankCount))
                .contains(0,0,0,0,0,0);
    }

}
