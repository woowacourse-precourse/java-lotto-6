package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.PlayerLottos;
import lotto.model.ProfitCalculator;
import lotto.model.Statistics;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProfitCalculatorTest {

    private static final double prize = 1_502_500;
    private final List<Lotto> playerLottos = List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(3, 4, 5, 6, 7, 8))
    );

    private final WinningLotto winningLotto = new WinningLotto(
            new Lotto(List.of(3, 4, 5, 6, 8, 10)),
            new BonusNumber("7")
    );

    @DisplayName("수익률 계산 테스트")
    @Test
    void testRightProfitCalculator() {
        ProfitCalculator profitCalculator =
                new ProfitCalculator(2000,
                new Statistics(new PlayerLottos(playerLottos), winningLotto));

        assertThat(profitCalculator.getProfitRatio())
                .isEqualTo(prize);
    }
}
