package lotto.domain.result;

import static lotto.domain.result.Grade.FIFTH;
import static lotto.domain.result.Grade.FIRST;
import static lotto.domain.result.Grade.FOURTH;
import static lotto.domain.result.Grade.SECOND;
import static lotto.domain.result.Grade.THIRD;

import java.math.BigDecimal;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningMoneyTest {

    @Test
    void 당첨금을_계산한다() {
        // Arrange

        BigDecimal expected = BigDecimal.valueOf(FIRST.getWinningMoney())
                .add(BigDecimal.valueOf(SECOND.getWinningMoney()))
                .add(BigDecimal.valueOf(THIRD.getWinningMoney()))
                .add(BigDecimal.valueOf(FOURTH.getWinningMoney()))
                .add(BigDecimal.valueOf(FIFTH.getWinningMoney()))
                .add(BigDecimal.valueOf(FIFTH.getWinningMoney()));

        Statistics statistics = new Statistics();
        statistics.apply(FIRST);
        statistics.apply(SECOND);
        statistics.apply(THIRD);
        statistics.apply(FOURTH);
        statistics.apply(FIFTH);
        statistics.apply(FIFTH);

        // Act
        WinningMoney winningMoney = new WinningMoney(statistics);

        // Assert
        Assertions.assertThat(winningMoney.getMoney()).isEqualTo(expected);
    }
}