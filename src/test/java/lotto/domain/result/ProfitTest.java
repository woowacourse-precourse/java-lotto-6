package lotto.domain.result;

import static lotto.domain.result.Grade.FIFTH;
import static lotto.domain.result.Grade.FIRST;
import static lotto.domain.result.Grade.FOURTH;
import static lotto.domain.result.Grade.SECOND;
import static lotto.domain.result.Grade.THIRD;
import static lotto.io.write.OutputMessage.LOTTO_PROFIT_MESSAGE;
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

        Statistics statistics = new Statistics();
        statistics.apply(FIRST);
        statistics.apply(SECOND);
        statistics.apply(THIRD);
        statistics.apply(FOURTH);
        statistics.apply(FIFTH);

        WinningMoney winningMoney = new WinningMoney(statistics);

        // Act
        Profit profit = new Profit(winningMoney, purchaseCount);

        // Assert
        double expected = winningMoney.getMoney().doubleValue() / (purchaseCount * PURCHASE_AMOUNT_UNIT);
        assertThat(profit.getPercentage()).isEqualTo(expected);
    }

    @Test
    void 수익률을_출력한다() {
        int purchaseCount = 5;

        Statistics statistics = new Statistics();
        statistics.apply(FIRST);
        statistics.apply(SECOND);
        statistics.apply(THIRD);
        statistics.apply(FOURTH);
        statistics.apply(FIFTH);

        WinningMoney winningMoney = new WinningMoney(statistics);
        
        Profit profit = new Profit(winningMoney, purchaseCount);

        // Act
        profit.print();

        // Assert
        String expected = String.format(LOTTO_PROFIT_MESSAGE.getMessage(), profit.getPercentage());
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expected);
    }
}