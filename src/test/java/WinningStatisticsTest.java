import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import domain.WinningStatistics;
import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    @DisplayName("랜덤에서 가져온 로또번호와 당첨번호에서 같은 번호가 몇개있는지 확인한다.")
    @Test
    void setMatchingCountTest() {
        Lotto resultNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto userNumbers = new Lotto(List.of(2, 3, 4, 5, 6, 7));

        WinningStatistics winningStatistics = new WinningStatistics(resultNumbers, userNumbers);

        assertThat(5).isEqualTo(winningStatistics.getMatchingCount());
    }

    @DisplayName("랜덤 생성된 번호 중 보너스 번호가 있는지 확인한다.")
    @Test
    void setCheckBonusNumberTest() {
        Lotto resultNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;
        WinningStatistics winningStatistics = new WinningStatistics();
        boolean hasBonusNumber = winningStatistics.checkBonusNumber(resultNumbers, bonusNumber);
        assertTrue(hasBonusNumber);
    }

}