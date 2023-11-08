package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import lotto.util.MatchRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReturnMoneyTest {

    @DisplayName("수익률 계산이 맞는지 테스트")
    @Test
    void isCorrectReturnMoneyCalculation() {
        Map<MatchRanking, Integer> rankingCount = new HashMap<>();
        for (MatchRanking ranking : MatchRanking.values()) {
            rankingCount.put(ranking, 0);
            if (ranking.equals(MatchRanking.FIFTH_PLACE)) {
                rankingCount.put(ranking, 1);
            }
        }
        LottoPrice lottoPrice = new LottoPrice("8000");

        assertSimpleTest(() -> {
            ReturnMoney returnMoney = new ReturnMoney(rankingCount, lottoPrice);
            assertThat(returnMoney.getReturnMoney()).isEqualTo(62.5);
        });
    }
}
