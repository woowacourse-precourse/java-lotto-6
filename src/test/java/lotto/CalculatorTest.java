package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    Calculator calculator = new Calculator();
    @Test
    void 로또번호_당첨번호_3개_일치_테스트() {
        Lotto lottoNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> prizeNumber = List.of(1, 2, 3, 7, 8, 9);
        int bonusNumber = 10;

        calculator.calculatePrizeDescribe(lottoNumber, prizeNumber, bonusNumber);

        assertThat(calculator.getFifthPrize()).isEqualTo(1);
    }

    @Test
    void 로또번호_당첨번호_5개_일치_보너스번호_일치_테스트() {
        Lotto lottoNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> prizeNumber = List.of(1, 2, 3, 4, 5, 10);
        int bonusNumber = 6;

        calculator.calculatePrizeDescribe(lottoNumber, prizeNumber, bonusNumber);

        assertThat(calculator.getSecondPrize()).isEqualTo(1);
    }

    @Test
    void 수익률_테스트() {
        Lotto lottoNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> prizeNumber = List.of(1, 2, 3, 4, 8, 9);
        int bonusNumber = 10;
        int money = 8000;

        calculator.calculatePrizeDescribe(lottoNumber, prizeNumber, bonusNumber);

        assertThat(calculator.calculateEarningRate(money)).isEqualTo("625.0%");
    }
}
