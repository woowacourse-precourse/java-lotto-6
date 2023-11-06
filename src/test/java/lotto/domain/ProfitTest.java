package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import lotto.dto.ProfitResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("수익률 계산 테스트")
class ProfitTest {

    @Test
    void 구매개수와_상금으로_수익률을_계산하라 () {
        //given
        int count = 6;
        Map<Integer, Integer> prizeResult = new HashMap<>();
        prizeResult.put(2_000_000_000, 1);
        prizeResult.put(30_000_000, 1);
        prizeResult.put(1_500_000, 1);
        prizeResult.put(50_000, 1);
        prizeResult.put(5_000, 1);

        //when
        Profit profit = Profit.create(count, prizeResult);
        ProfitResponse profitResponse = profit.generateProfitResponse();
        double lottoProfit = profitResponse.getResponse();

        //then
        assertThat(lottoProfit).isEqualTo(338_592.5);
    }

}
