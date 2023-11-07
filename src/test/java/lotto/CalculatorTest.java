package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import model.Calculator;
import model.Lotto;
import model.LottoBundle;
import model.PrizeStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    LottoBundle lottoBundle = LottoBundle.getInstance();
    PrizeStatistics prizeStatistics = PrizeStatistics.getInstance();

    @Test
    void calculateMoneyToLottoCountTest() {
        // given
        Calculator calculator = new Calculator();
        // when
        int money = 10000;
        // then
        assertThat(calculator.calculateMoneyToLottoCount(money)).isEqualTo(10);
    }

    @DisplayName("당첨 번호, 보너스 번호와 로또 번호를 비교했을 때 결과가 정확한지 확인하는 테스트")
    @Test
    void calculatePrizeTest() {
        // given
        Calculator calculator = new Calculator();
        lottoBundle.getLottoBundle().add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        // when
        calculator.calculatePrizeStatistics(List.of(11, 21, 31, 17, 18, 19), 10);
        // then
        assertThat(prizeStatistics.getFifthPrize()).isEqualTo(1);
    }

    @DisplayName("구입 금액으로 총 수익률을 계산했을 때 결과가 정확한지 확인하는 테스트")
    @Test
    void calculateEarningRateTest() {
        // given
        Calculator calculator = new Calculator();
        lottoBundle.getLottoBundle().add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        // when
        calculator.calculatePrizeStatistics(List.of(1, 2, 3, 7, 8, 9), 10);
        // then
        assertThat(calculator.calculateEarningRate(1000)).isEqualTo("500.0%");
    }

}