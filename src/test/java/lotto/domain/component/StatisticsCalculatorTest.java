package lotto.domain.component;

import lotto.domain.component.StatisticsCalculator;
import lotto.domain.dto.Statistics;
import lotto.domain.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsCalculatorTest {

    @Test
    void 수익률이_100_이상일_경우의_최종_결과를_통계로_반환한다() {

        // given
        StatisticsCalculator calculator = new StatisticsCalculator();
        Lottos generatedLottos = new Lottos();
        generatedLottos.addLotto(List.of(1, 2, 3, 4, 5, 6));
        generatedLottos.addLotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7, winningNumber);
        Money money = new Money(2000);

        List<Result> expcetedResults = List.of(Result.SIX_MATCH, Result.FIVE_MATCH_WITH_BONUS);
        double expectedRate = 101500000.0;

        // when
        Statistics actual = calculator.calculate(generatedLottos, winningNumber, bonusNumber, money);

        // then
        assertEquals(new Statistics(expcetedResults, expectedRate), actual);
    }

    @Test
    void 수익률이_100_이하일_경우의_최종_결과를_통계로_반환한다() {

        // given
        StatisticsCalculator calculator = new StatisticsCalculator();
        Lottos generatedLottos = new Lottos();
        generatedLottos.addLotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 43, 44, 45));
        BonusNumber bonusNumber = new BonusNumber(7, winningNumber);
        Money money = new Money(16000);

        List<Result> expcetedResults = List.of(Result.THREE_MATCH);
        double expectedRate = 31.25;

        // when
        Statistics actual = calculator.calculate(generatedLottos, winningNumber, bonusNumber, money);

        // then
        assertEquals(new Statistics(expcetedResults, expectedRate), actual);
    }

    @Test
    void 수익률이_0일_경우의_최종_결과를_통계로_반환한다() {

        // given
        StatisticsCalculator calculator = new StatisticsCalculator();
        Lottos generatedLottos = new Lottos();
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7, winningNumber);
        Money money = new Money(1000);

        List<Result> expcetedResults = List.of();
        double expectedRate = 0.0;

        // when
        Statistics actual = calculator.calculate(generatedLottos, winningNumber, bonusNumber, money);

        // then
        assertEquals(new Statistics(expcetedResults, expectedRate), actual);
    }
}
