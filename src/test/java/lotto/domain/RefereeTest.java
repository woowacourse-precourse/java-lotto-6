package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {
    @DisplayName("로또의 등수를 결정하여 결과를 반환한다.")
    @Test
    void judgeAll() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
        winningNumber.setBonusNumber(7);
        Referee referee = new Referee(winningNumber);
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        WinningResult actual = referee.judgeRanks(lottos);

        assertThat(actual.getValues()).containsKey(Rank.FIRST).containsValue(1);
    }
}
