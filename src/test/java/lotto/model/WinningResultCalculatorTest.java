package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.fixture.LottosFixture;
import lotto.fixture.WinningLottoFixture;
import lotto.fixture.WinningResultCalculatorFixture;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class WinningResultCalculatorTest {

    @Test
    void 당첨_결과를_계산한다() {
        // given
        WinningResultCalculator calculator = WinningResultCalculatorFixture.create();
        WinningLotto winningLotto = WinningLottoFixture.create("1,2,3,4,5,6", "7");
        Lottos lottos = LottosFixture.create(1, List.of(1, 2, 3, 4, 5, 6));

        // when
        Map<Rank, Integer> winningStatus = calculator.calculateWinningStatus(winningLotto, lottos);

        // then
        assertThat(winningStatus.get(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    void 수익률을_계산한다() {
        // given
        WinningResultCalculator calculator = WinningResultCalculatorFixture.create();
        WinningLotto winningLotto = WinningLottoFixture.create("1,2,3,4,5,6", "7");
        Lottos lottos = LottosFixture.create(1, List.of(1, 2, 3, 4, 5, 10));
        Money money = Money.from("1000");
        Map<Rank, Integer> winningStatus = calculator.calculateWinningStatus(winningLotto, lottos);

        // when
        double returnRate = calculator.getReturnRate(winningStatus, money);

        // then
        assertThat(returnRate).isEqualTo(150000);
    }
}
