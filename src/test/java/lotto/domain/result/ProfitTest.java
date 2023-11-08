package lotto.domain.result;

import static lotto.domain.grade.Grade.FIFTH;
import static lotto.domain.grade.Grade.FIRST;
import static lotto.domain.grade.Grade.FOURTH;
import static lotto.domain.grade.Grade.SECOND;
import static lotto.domain.grade.Grade.THIRD;
import static lotto.utils.LottoConstant.PROFIT_MULTIPLY;
import static lotto.utils.LottoConstant.PURCHASE_AMOUNT_UNIT;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProfitTest {

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void 수익률을_조회한다() {
        // Arrange
        int purchaseCount = 5;

        Statistics statistics = Statistics.of();
        statistics.apply(FIRST);
        statistics.apply(SECOND);
        statistics.apply(THIRD);
        statistics.apply(FOURTH);
        statistics.apply(FIFTH);

        WinningMoney winningMoney = WinningMoney.of();
        winningMoney.apply(statistics);

        Profit profit = Profit.of();

        double expected =
                (winningMoney.getMoney().doubleValue() / (purchaseCount * PURCHASE_AMOUNT_UNIT)) * PROFIT_MULTIPLY;

        // Act
        profit.apply(winningMoney, purchaseCount);

        // Assert
        double actual = profit.getPercentage();
        assertThat(actual).isEqualTo(expected);
    }
}