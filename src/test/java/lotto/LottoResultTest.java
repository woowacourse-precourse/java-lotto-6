package lotto;

import java.util.List;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @DisplayName("집계가 올바른 결과를 반환한다.")
    @Test
    void aggregateTest() {
        LottoResult result = new LottoResult();
        List<Prize> prizes = List.of(Prize.FIRST, Prize.SECOND, Prize.SECOND, Prize.THIRD, Prize.FIFTH, Prize.BLANK);
        long totalCost = LottoMachine.lottoCost * prizes.size();
        long totalReward = prizes.stream().map(Prize::getReward).reduce(Long::sum).get();
        double roi = Math.round((double) totalReward / totalCost * 100 * 10) / 10.0;

        prizes.forEach(result::aggregate);

        assertThat(result.getPrizeReport(Prize.FIRST)).contains("1개");
        assertThat(result.getPrizeReport(Prize.SECOND)).contains("2개");
        assertThat(result.getPrizeReport(Prize.THIRD)).contains("1개");
        assertThat(result.getPrizeReport(Prize.FOURTH)).contains("0개");
        assertThat(result.getPrizeReport(Prize.FIFTH)).contains("1개");
        assertThat(result.getPrizeReport(Prize.BLANK)).contains("1개");
        assertThat(result.getROIReport()).contains(String.format("%.1f", roi));
    }

}
