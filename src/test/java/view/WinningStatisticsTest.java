package view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    @DisplayName("랜덤에서 가져온 로또번호와 당첨번호에서 같은 번호가 몇개있는지 확인한다.")
    @Test
    void matchOfCountTest() {
        Lotto resultNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto userNumbers = new Lotto(List.of(2, 3, 4, 5, 6, 7));

        WinningStatistics winningStatistics = new WinningStatistics(resultNumbers, userNumbers);

        assertThat(5).isEqualTo(winningStatistics.getMatchingCount());
    }

}