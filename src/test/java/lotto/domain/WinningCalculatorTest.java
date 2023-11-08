package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.constants.WinningType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningCalculatorTest {
    private WinningCalculator calculator;
    private Lottos lottos;
    private Winning winning;

    @BeforeEach
    void testInit() {
        calculator = new WinningCalculator();
        lottos = new Lottos();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 11, 22, 33));

        lottos.addLotto(lotto);
        lottos.addLotto(lotto);
        lottos.addLotto(lotto);

        winning = new Winning(List.of(1, 2, 3, 4, 5, 6));
        winning.setBonusNumber(7);
    }

    @DisplayName("5등의 당첨 횟수는 3이다.")
    @Test
    void testWinningCounts() {
        Integer expectedFifthCount = 3;

        calculator.caculate(lottos, winning);

        assertThat(calculator.getCount(WinningType.FIFTH)).isEqualTo(expectedFifthCount);
    }

    @DisplayName("3개의 복권을 샀을때 3개 모두 5등에 당첨 된다고 한다면 총 수익률은 500% 이다.")
    @Test
    void testProfitMargin() {
        Double expectedProfitMargin = 500.0;

        calculator.caculate(lottos, winning);

        assertThat(calculator.calculateProfitMargin(3000)).isEqualTo(expectedProfitMargin);
    }
}