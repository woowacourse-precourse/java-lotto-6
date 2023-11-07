package lotto;

import lotto.domain.Lotto;
import lotto.domain.ResultType;
import lotto.service.ResultService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    final ResultService resultService = new ResultService();

    @DisplayName("로또 번호와 당첨 번호를 비교해서 같은 번호의 개수를 파악한다.")
    @Test
    void compareLottoWithWinningNumber() {
        assertThat(resultService.compareLotto(new Lotto(Arrays.asList(1,2,3,4,5,6)),new Lotto(Arrays.asList(1,2,3,7,8,9))))
                .isEqualTo(3);
    }
    @DisplayName("로또 번호와 보너스 번호르 비교해서 같은 지 확인한다.")
    @Test
    void compareBonusWithWinningNumber() {
        assertThat(resultService.compareBonus(new Lotto(Arrays.asList(1,2,3,4,5,6)),5))
                .isEqualTo(true);
    }
    @DisplayName("당첨 결과를 구한다.")
    @Test
    void makeResult() {
        assertThat(resultService.finalResult(5,true)).isEqualTo(ResultType.FIVEBONUS);
    }
    @DisplayName("당첨금을 계산한다.")
    @Test
    void calculatePrize() {
        assertThat(resultService.calculatePrize(Map.of(ResultType.FIVEBONUS,2)))
                .isEqualTo(60000000);
    }
    @DisplayName("수익률을 계산한다.")
    @Test
    void calculateProfit() {
        double profit = resultService.calculateProfit(15000,7000);
        assertThat(Math.round(profit*10)/10.0).isEqualTo(46.7);

    }
}
