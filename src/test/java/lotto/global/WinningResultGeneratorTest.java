package lotto.global;

import lotto.domain.game.WinningResultGenerator;
import lotto.global.constant.LottoRank;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultGeneratorTest {

    @Test
    void 메시지를_잘_만드는지_확인() {
        String expected = "3개 일치 (5,000원) - 0개\n" +
                "4개 일치 (50,000원) - 1개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개\n" +
                "6개 일치 (2,000,000,000원) - 1개\n";

        Map<LottoRank, Integer> resultMap = new HashMap<>();
        resultMap.put(LottoRank.OUT_OF_RANK, 1);
        resultMap.put(LottoRank.FOURTH_PLACE, 1);
        resultMap.put(LottoRank.FIRST_PLACE, 1);
        resultMap.put(LottoRank.SECOND_PLACE, 2);

        String result = WinningResultGenerator.generateWinningResults(resultMap);

        assertThat(result)
                .isEqualTo(expected);
    }
}
