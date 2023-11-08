package lotto.domain.result;

import static lotto.domain.grade.Grade.FIFTH;
import static lotto.domain.grade.Grade.FIRST;
import static lotto.domain.grade.Grade.FOURTH;
import static lotto.domain.grade.Grade.SECOND;
import static lotto.domain.grade.Grade.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
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

        Statistics statistics = Statistics.of();
        statistics.apply(FIRST);
        statistics.apply(SECOND);
        statistics.apply(THIRD);
        statistics.apply(FOURTH);
        statistics.apply(FIFTH);
        statistics.apply(FIFTH);
        WinningMoney winningMoney = WinningMoney.of();

        // Act
        winningMoney.apply(statistics);

        // Assert
        BigDecimal actual = winningMoney.getMoney();
        assertThat(actual).isEqualTo(expected);
    }
}