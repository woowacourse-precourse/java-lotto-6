package lotto;

import lotto.controller.StatisticsController;
import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.domain.WinningBonusLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StatisticsTest {
    @DisplayName("수익률 계산")
    @Test
    void isEqualStatisticsRate() {
        int payment = 1000;
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        ArrayList<Lotto> lottos = new ArrayList<Lotto>();
        lottos.add(lotto);
        Lotto winningLotto = new Lotto(List.of(1,2,3,7,8,9));
        int bonusNumber = 45;
        WinningBonusLotto winningBonus = new WinningBonusLotto(winningLotto, bonusNumber);
        Player player = new Player(payment);

        double result = 500.0;

        player.setLottos(lottos);
        player.setWinningBonusLotto(winningBonus);

        StatisticsController controller = new StatisticsController();
        controller.CountWinningNumber(player);

        assertThat(result).isEqualTo(controller.calculateRate());
    }
}
