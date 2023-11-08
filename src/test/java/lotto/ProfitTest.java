package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitTest {
    @Test
    @DisplayName("getProfitRate: 10개 뽑아서 2등과 4등에 하나씩 당첨되었을 때: 300500% 수익")
    void getProfitRateTest() {
        Result result = new Result();
        List<Score> scores = new ArrayList<>();
        Profit profit =new Profit();
        
        scores.add(Score.SECOND); //30000000
        scores.add(Score.FOURTH); //50000

        result.setScores(scores);
        int moneyInput = 10000;
        profit.findProfitRate(result, moneyInput);

        assertThat(profit.getProfitRate()).isEqualTo(300500);
        
    }
}
